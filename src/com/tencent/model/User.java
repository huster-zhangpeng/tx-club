package com.tencent.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User extends BaseBean {

    /**
     *
     */
    private static final long serialVersionUID = 8589012136768444470L;
    private String username;
    private String password;
    private String sex;  //only one bite in database 'tencent_test.user'
    private Date birthday = null;
    private String email;
    private String qq;
    private String phone;
    private String major;
    private String grade;
    private int score;
    private String description;
    private int level=1;
    private String photoUrl;
    private String miniPhoto;
    private String address = null;
    //数据库里记录是否登录状态
    private int state=0;
    private Set<Blog> blogs = new HashSet<Blog>();
    private Set<Task> tasks = new HashSet<Task>();
    private Set<Message> messages = new HashSet<Message>();
    private Set<Team> teams = new HashSet<Team>();
    private Set<Resource> resources = new HashSet<Resource>();

    public User() {
        super();
    }

    public User(String username, String password, String sex, String email,
			String qq, String phone, String major, String grade, int score,
			String description, int level, int state) {
		super();
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.email = email;
		this.qq = qq;
		this.phone = phone;
		this.major = major;
		this.grade = grade;
		this.score = score;
		this.description = description;
		this.level = level;
		this.state = state;
	}

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Column(name = "photo_url")
    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Column(name = "mini_photo")
    @Basic(fetch = FetchType.LAZY)
    public String getMiniPhoto() {
        return miniPhoto;
    }

    public void setMiniPhoto(String miniPhoto) {
        this.miniPhoto = miniPhoto;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @OneToMany(mappedBy = "author")
    public Set<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(Set<Blog> blogs) {
        this.blogs = blogs;
    }

    @OneToMany(mappedBy = "builder")
    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    @ManyToMany(mappedBy = "acceptors")
    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    @ManyToMany(mappedBy = "members")
    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    @ManyToMany
    @JoinTable(name = "user_resource",
    joinColumns = {
        @JoinColumn(name = "id_user", referencedColumnName = "id")
    },
    inverseJoinColumns = {
        @JoinColumn(name = "id_resource", referencedColumnName = "id")
    })
    public Set<Resource> getResources() {
        return resources;
    }

    public void setResources(Set<Resource> resources) {
        this.resources = resources;
    }
}
