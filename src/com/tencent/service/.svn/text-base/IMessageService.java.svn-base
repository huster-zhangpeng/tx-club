package com.tencent.service;

import java.sql.Timestamp;
import java.util.List;

import com.mysql.jdbc.Blob;
import com.tencent.model.Message;
import com.tencent.model.Team;
import com.tencent.model.User;

public interface IMessageService extends IService<Message> {
	public Message findByTopic(String topic);

    public Message createMessage(User sender, Blob content, Timestamp sendDate, int type, Team... teams);

    public boolean sendMessages(Message message);

    public int cancelMessage(int userId, Message message);

	public List<Message> listOutDate(User user, boolean isOutdate);

	public List<Message> listOutDate(User user, boolean isOutdate, int firstResult,
			int maxSize);
}
