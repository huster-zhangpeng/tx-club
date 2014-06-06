package com.tencent.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="contactus")
public class ContactUs extends BaseBean {

    /**
     *
     */
    private static final long serialVersionUID = -7345224338413422397L;
    private String nickname;
    private String content;
    private Date createDate;

    public ContactUs() {
        super();
    }

    public ContactUs(String nickname, String content, Date createDate) {
        super();
        this.nickname = nickname;
        this.content = content;
        this.createDate = createDate;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "create_date")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
