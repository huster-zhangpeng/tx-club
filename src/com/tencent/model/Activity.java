package com.tencent.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="activity")
public class Activity extends BaseBean {

    /**
     *
     */
    private static final long serialVersionUID = 1860961376762891359L;
    private String name;
    private Timestamp startDate = null;
    private Timestamp endDate = null;
    private User creator;
    private String location;
    private String description;
    private int state;
    private Set<Team> teams = new HashSet<Team>();
    private Set<Resource> resoures = new HashSet<Resource>();
    private int scope;

    public Activity() {
    }

    public Activity(String name, String location,
			String description, int state, int scope) {
		super();
		this.name = name;
		this.location = location;
		this.description = description;
		this.state = state;
		this.scope = scope;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "start_date")
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Column(name = "end_date")
    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    @OneToOne
    @JoinColumn(name="id_creator")
    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic(fetch = FetchType.LAZY)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "team_activity",
    joinColumns = {
        @JoinColumn(name = "id_team", referencedColumnName = "id")
    },
    inverseJoinColumns = {
        @JoinColumn(name = "id_activity", referencedColumnName = "id")
    })
    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    @ManyToMany
    @JoinTable(name = "activity_resource",
    joinColumns = {
        @JoinColumn(name = "id_activity", referencedColumnName = "id")
    },
    inverseJoinColumns = {
        @JoinColumn(name = "id_resource", referencedColumnName = "id")
    })
    public Set<Resource> getResoures() {
        return resoures;
    }

    public void setResoures(Set<Resource> resoures) {
        this.resoures = resoures;
    }

    public int getScope() {
        return scope;
    }

    public void setScope(int scope) {
        this.scope = scope;
    }
}
