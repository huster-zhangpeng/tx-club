package com.tencent.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "task")
public class Task extends BaseBean {

	/**
     *
     */
	private static final long serialVersionUID = 2327589779962365030L;
	private String content;
	private int type;
	private boolean status;
	private Timestamp startDate;
	private User builder;
	private Set<Team> acceptedTeams = new HashSet<Team>();

	public Task() {
		super();
	}

	public Task(String content, int type, boolean status) {
		super();
		this.content = content;
		this.type = type;
		this.status = status;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Column(name = "start_date")
	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	@ManyToOne
	@JoinColumn(name = "id_builder")
	public User getBuilder() {
		return builder;
	}

	public void setBuilder(User builder) {
		this.builder = builder;
	}

	@ManyToMany
	@JoinTable(name = "task_team", joinColumns = { @JoinColumn(name = "id_task", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "id_team", referencedColumnName = "id") })
	public Set<Team> getAcceptedTeams() {
		return acceptedTeams;
	} // for example,WangQiang give tasks to Group web and Group phone

	public void setAcceptedTeams(Set<Team> acceptedTeams) {
		this.acceptedTeams = acceptedTeams;
	}
}
