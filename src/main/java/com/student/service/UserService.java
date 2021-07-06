package com.student.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.student.dao.RoleRepository;
import com.student.dao.UserRepository;
import com.student.dao.UserRolesRepository;
import com.student.model.Role;
import com.student.model.User;
import com.student.model.UserRoles;
import com.student.model.UserView;
import com.student.model.payloads.SignupRequest;

@Service
public class UserService {
	@Autowired
	private RoleRepository mRoleRepository;
	@Autowired
	private UserRepository mUserRepository;
	@Autowired
	private UserRolesRepository mUserRoleRepository;
	@Autowired
	private PasswordEncoder mPasswordEncoder;
	
	public UserView createUser(SignupRequest request) {
		if(mUserRepository.findByUsername(request.getUsername()) != null)
			throw new RuntimeException("User already exists");
		
		if(!request.getPassword().equals(request.getRePassword()))
			throw new RuntimeException("Passwords not matched");
		
		// Create User
		User user = new User();
		user.setUsername(request.getUsername());
		user.setPassword(mPasswordEncoder.encode(request.getPassword()));
		//user.setActive(true);
		user = mUserRepository.save(user);
		
		// Password
		insertRole(user, request.getAuthorities());
		return getUserView(user);
	}
	
	private void insertRole(User user, Set<String> roles) {
		List<Role> availableRole = mRoleRepository.findAll();
	
		
		Map<String, Role> roleMap = new HashMap<String, Role>();
		List<UserRoles> userRoles = new ArrayList<UserRoles>();
		
		for(Role role : availableRole) 
			roleMap.put(role.getRoleType().toString(), role);
		
		roles.forEach((type) -> {
			if(roles.contains(type.toString())) {
				userRoles.add(new UserRoles(null, user, roleMap.get(type)));
			}
		});
		
		mUserRoleRepository.saveAll(userRoles);
	}
	
	public UserView getUserView(User user) {
		UserView userView = new UserView();
		userView.setUsername(user.getUsername());
		userView.setId(user.getId());
		return userView;
	}
	
		

}
