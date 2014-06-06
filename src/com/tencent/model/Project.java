package com.tencent.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="project")
public class Project extends BaseBean {

    /**
     *
     */
    private static final long serialVersionUID = 2839463706085746375L;
    private String name;
    private User charger;
    /**
     * type == 0 表示 是一个网站工程
     * type == 1 表示 是一个手机作品
     * type == 2 表示 其他作品
     */
    private int type;
    private Timestamp startDate;
    private Timestamp endDate;
    private String description;
    private String image;
    private int defficulty;
    private int state;
    private User consignor;
    private Set<Resource> resources = new HashSet<Resource>();
    private Team team;

    public Project() {
        super();
    }

    public Project(String name, int type, String description, int state) {
		super();
		this.name = name;
		this.type = type;
		this.description = description;
		this.state = state;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToOne
    @JoinColumn(name="id_charger")
    public User getCharger() {
        return charger;
    }

    public void setCharger(User charger) {
        this.charger = charger;
    }

    public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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

    @Basic(fetch = FetchType.LAZY)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getDefficulty() {
		return defficulty;
	}

	public void setDefficulty(int defficulty) {
		this.defficulty = defficulty;
	}

	public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @OneToOne
    @JoinColumn(name="id_consignor")
    public User getConsignor() {
        return consignor;
    }

    public void setConsignor(User consignor) {
        this.consignor = consignor;
    }

    @ManyToMany
    @JoinTable(name = "project_resource",
    joinColumns = {
        @JoinColumn(name = "id_project", referencedColumnName = "id")
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

    @OneToOne
    @JoinColumn(name="id_team")
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
