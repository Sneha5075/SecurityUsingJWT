package com.student.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.student.dao.UserRepository;
import com.student.model.User;

@Component
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	private User findById;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User users = userRepository.findByUsername(username);
		
		if(users==null)
			throw new UsernameNotFoundException("user  doesn't exist with username "+username);
		return UserPrincipal.create(users);
	}
	
	public UserDetails loaduserById(int userId) {
		User user = userRepository.findById(userId);
		if(user==null)
			throw new UsernameNotFoundException("user not found with id "+userId);
		return UserPrincipal.create(user);
	}

}
