package com.student.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.student.utils.Utils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name="user")
@Getter
@Setter
@ToString
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String username;
	private String password;
	@ManyToOne
	@JoinColumn(name="student_id")
	private Student student;
	
	@Column(name="access_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date accessTime;
	
	@Column(name="update_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateTime;
	
	@Column(name="creation_time")
	private Date creationTime;
	
	@PrePersist
	public void onUpdate() {
		this.setUpdateTime(Utils.now());
		this.setAccessTime(Utils.now());
	}
	
	protected void onCreate() {
		if(this.getCreationTime()==null)
			this.setCreationTime(new Date());
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
			name = "user_roles",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id"))
	Set<Role> roles = new HashSet<Role>();

}
