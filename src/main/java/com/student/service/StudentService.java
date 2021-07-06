package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dao.StudentRepository;
import com.student.model.Student;


@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getStudents() {
	
		return studentRepository.findAll();
	}

}
