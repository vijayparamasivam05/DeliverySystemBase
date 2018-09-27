package com.spring.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="Interest")
public class Interest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne
	@ForeignKey(name="user")
	@Autowired
	private User user;

	@ManyToOne
	@ForeignKey(name="location")
	@Autowired
	private Location location;
	
	@Column(name="status")
	private String status;
	
	public Interest(Integer id, User user, String status) {
		super();
		this.id = id;
		this.user = user;
		this.status = status;
	}
	public Interest( User user, String status) {
		super();
		this.user = user;
		this.status = status;
	}

	public Interest() {}
	public Interest(Integer id, User user) {
		super();
		this.id = id;
		this.user = user;
	}
	
	public Interest(Integer id, User user, Location location, String status) {
		super();
		this.id = id;
		this.user = user;
		this.location = location;
		this.status = status;
	}
	
	public Interest( User user, Location location, String status) {
		super();
		this.user = user;
		this.location = location;
		this.status = status;
	}
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Interest( User user) {
		super();
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}