package com.student.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="role")
@Getter
@Setter
@ToString
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
//	private int role;
	public enum RoleType{
		STUDENT,
		TEACHER,
		ADMIN
	}
	@Column(name="role")
	@Enumerated(EnumType.ORDINAL)
	private RoleType roleType;

}
