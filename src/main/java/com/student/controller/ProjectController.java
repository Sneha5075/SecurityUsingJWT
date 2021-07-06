package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.dao.StudentRepository;
import com.student.model.Project;
import com.student.model.Student;
import com.student.service.ProjectService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/project")
@AllArgsConstructor
public class ProjectController {
	@Autowired
	private final ProjectService projectService;
	@Autowired
	private final StudentRepository mStudentRepository;
	
	@PostMapping("")
	public ResponseEntity<?> create(@RequestBody Project project,
						@RequestParam("firstName") String firstName,
						@RequestParam("LastName") String LastName,
						@RequestParam("mobile") String mobile,
						@RequestParam("email") String email,
						@RequestParam("password") String password) {
		
		Student student=new Student();
		student.setFirstName(firstName);
		student.setLastName(LastName);
		student.setMobile(mobile);
		student.setEmail(email);
		student.setPassword(password);
		student = mStudentRepository.save(student);
		project.setStudent(student);
		project=projectService.insert(project);
		
		return new ResponseEntity<Project>(project,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAll()
	{
		List<Project> all = projectService.getAll();
		return new ResponseEntity<List<Project>>(all,HttpStatus.OK);
	}
	
	@GetMapping("/query")
	public ResponseEntity<?> getAllById(@RequestParam("studentId") Integer studentId) {
		List<Project> all = projectService.getAllById(studentId);
		return new ResponseEntity<List<Project>>(all,HttpStatus.OK);
	}

}
