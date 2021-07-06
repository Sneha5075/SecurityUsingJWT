package com.student.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dao.ProjectRepository;
import com.student.dao.StudentRepository;
import com.student.model.Project;
import com.student.model.Student;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private StudentRepository studentRepository;

	public Project insert(Project project, Integer studentId) {
		System.out.println(studentId);
		Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
		
		project.setStudent(student);
		project=projectRepository.save(project);
		
		return project;
	}

	public Project insert(Project project) {
		// TODO: Upload photo of project
		project=projectRepository.save(project);
		
		return project;
	}
	
	public List<Project> getAllById(Integer studentId) {
		 return projectRepository.findAllByStudentdIDs(Arrays.asList(studentId));
	}

	public List<Project> getAll() {
		
		return projectRepository.findAll();
	}

	

}
