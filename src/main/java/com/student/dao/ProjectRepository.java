package com.student.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.student.model.Project;



public interface ProjectRepository extends JpaRepository<Project,Integer>{

	public List<Project> findAllByStudentIdIn(List<Long> studentIDs);

	@Query("SELECT p from Project p WHERE p.student.id in ?1")
	public List<Project> findAllByStudentdIDs(List<Integer> studentId);

}



