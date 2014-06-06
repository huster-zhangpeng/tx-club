package com.tencent.model;

import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

@Entity
@Table(name="resource")
public class Resource extends BaseBean {

    private static final long serialVersionUID = -604469361972935491L;
    private String title;
    //temporary or persistent
    private int type;
    private Timestamp createDate;
    private int input = 0;
    // in use or not
    private int status;
    private int output = 0;
    private String cause;
    private String content;

    public Resource() {
        super();
    }

    public Resource(String title, int type, int status, String cause, String content) {
		super();
		this.title = title;
		this.type = type;
		this.status = status;
		this.cause = cause;
		this.content = content;
	}

	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Column(name = "create_date")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public int getInput() {
        return input;
    }

    public void setInput(int input) {
        this.input = input;
    }

    public int getOutput() {
        return output;
    }

    public void setOutput(int output) {
        this.output = output;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic(fetch=FetchType.LAZY)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
