package com.student.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.student.model.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	public User findByUsername(String username);

	public User findById(int id);
	
} 


