package com.tencent.model;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "message")
public class Message extends BaseBean {

	/**
     *
     */
	private static final long serialVersionUID = -6889092665781552636L;
	private User sender;
	private String topic;
	private Blob content;
	private boolean outdate;
	private int type;
	private Timestamp sendDate;
	private Set<Team> teams = new HashSet<Team>();
	private Set<User> acceptors = new HashSet<User>();

	public Message() {
		super();
	}

	public Message(String topic, boolean outdate, int type) {
		super();
		this.topic = topic;
		this.outdate = outdate;
		this.type = type;
	}

	@OneToOne
	@JoinColumn(name = "id_sender")
	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public Blob getContent() {
		return content;
	}

	public void setContent(Blob content) {
		this.content = content;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public boolean getOutdate() {
		return outdate;
	}

	public void setOutdate(boolean outdate) {
		this.outdate = outdate;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Column(name = "send_date")
	public Timestamp getSendDate() {
		return sendDate;
	}

	public void setSendDate(Timestamp sendDate) {
		this.sendDate = sendDate;
	}

	@ManyToMany
	@JoinTable(name = "message_team", joinColumns = { @JoinColumn(name = "id_message", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "id_team", referencedColumnName = "id") })
	public Set<Team> getTeams() {
		return teams;
	}

	public void setTeams(Set<Team> teams) {
		this.teams = teams;
	}

	@ManyToMany
	@JoinTable(name = "message_user", joinColumns = { @JoinColumn(name = "id_message", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "id_user", referencedColumnName = "id") })
	public Set<User> getAcceptors() {
		return acceptors;
	}

	public void setAcceptors(Set<User> acceptors) {
		this.acceptors = acceptors;
	}
}
