package com.tencent.service.impl;

import java.io.File;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.apache.log4j.Logger;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.mysql.jdbc.Blob;
import com.tencent.dao.IMessageDAO;
import com.tencent.dao.impl.MessageDAOImpl;
import com.tencent.model.Message;
import com.tencent.model.Team;
import com.tencent.model.User;
import com.tencent.service.IMessageService;

public class MessageServiceImpl extends ServiceImpl<Message>
        implements IMessageService {
	public static Logger log = Logger.getLogger(MessageServiceImpl.class);

    @Override
	public Message findByTopic(String topic) {
		return ((IMessageService)dao).findByTopic(topic);
	}

	private JavaMailSenderImpl mailSender;

    public JavaMailSenderImpl getMailSender() {
        return this.mailSender;
    }

    public void setMailSender(JavaMailSenderImpl mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public List<Message> listOutDate(User user, boolean isOutdate) {
        return ((IMessageDAO) super.dao).listOutDate(user, isOutdate);
    }

    @Override
    public List<Message> listOutDate(User user, boolean isOutdate,
            int firstResult, int maxSize) {
        return ((IMessageDAO) super.dao).listOutDate(user, isOutdate, firstResult, maxSize);
    }

    @Override
    public Message createMessage(User sender, Blob content, Timestamp sendDate,
            int type, Team... teams) {
        Message message = new Message();
        message.setSender(sender);
        message.setContent(content);
        message.setSendDate(sendDate);
        message.setType(type);
        message.setOutdate(false);
        message.getTeams().addAll(Arrays.asList(teams));
        int id = ((MessageDAOImpl) super.dao).save(message);
        message = dao.findById(Message.class, id);
        if (sendDate == null) {
            this.sendMessages(message);
        }
        return message;
    }

    @Override
    public boolean sendMessages(Message message) {
        JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
        MimeMessage mailMessage = senderImpl.createMimeMessage();
        // 设置UTF-8或GBK编码，否则邮件会有乱码
        MimeMessageHelper messageHelper;
        try {
            messageHelper = new MimeMessageHelper(mailMessage,
                    true, "utf-8");
        } catch (MessagingException e1) {
            e1.printStackTrace();
            return false;
        }
        Set<User> users = message.getAcceptors();
        Set<Team> teams = message.getTeams();
        int size = users.size();
        Iterator<Team> iterator = teams.iterator();
        while (iterator.hasNext()) {
            size = size + iterator.next().getMembers().size();
        }
        String[] strAddrs = new String[size];
        int i = 0;
        for (Iterator<User> iUser = users.iterator(); iUser.hasNext(); i++) {
            strAddrs[i] = iUser.next().getEmail();
        }
        for (Iterator<Team> iTeam = teams.iterator(); iTeam.hasNext();) {
            for (Iterator<User> _iUser = iTeam.next().getMembers().iterator(); _iUser.hasNext(); i++) {
                strAddrs[i] = _iUser.next().getEmail();
            }
        }

        try {
            messageHelper.setTo(strAddrs);// 接受者
            messageHelper.setFrom(message.getSender().getUsername());// 发送者
            messageHelper.setSubject(message.getTopic());// 主题
            // 邮件内容，注意加参数true
            messageHelper.setText(
                    "<html><head></head><body><h1>hello!!chao.wang</h1></body></html>",
                    true);
            // 附件内容
            messageHelper.addInline("a", new File("E:/xiezi.jpg"));
            messageHelper.addInline("b", new File("E:/logo.png"));
            File file = new File("E:/测试中文文件.rar");
            // 这里的方法调用和插入图片是不同的，使用MimeUtility.encodeWord()来解决附件名称的中文问题
            messageHelper.addAttachment(MimeUtility.encodeWord(file.getName()),
                    file);
            mailSender.send(mailMessage);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        message.setOutdate(true);
        ((MessageDAOImpl) super.dao).update(message);
        return true;
    }

    @Override
    public int cancelMessage(int userId, Message message) {
        if (message.getSender().getId() != userId) {
            return -1;
        } else if (message.getOutdate()) {
            return 0;
        }
        ((MessageDAOImpl) super.dao).delete(message);
        return 1;
    }
 
    @Resource(name="messageDao")
    public void setDao(IMessageDAO dao) {
        this.dao = dao;
    }
	
	public IMessageDAO getDao(){
		return (IMessageDAO) this.dao;
	}
}
