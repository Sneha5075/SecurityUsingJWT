package com.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.model.UserRoles;

@Repository
public interface UserRolesRepository extends JpaRepository<UserRoles,Integer> {

}
