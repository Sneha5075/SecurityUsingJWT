package com.student.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="project")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Project {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "duration")
	private int duration;
	
	@Column(length=500)
	private String description;
	
	@ManyToOne
	@JoinColumn(name ="student_id")
	private Student student;
	

	@Column(name = "creation_time")
	private Date creationTime;
	
	@PrePersist
	protected void onCreate() {
		if(this.getCreationTime() == null)
			this.setCreationTime(new Date());
	}

}
