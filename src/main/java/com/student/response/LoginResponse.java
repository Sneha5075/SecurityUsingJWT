package com.student.response;

import com.student.model.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {
	Integer httpStatusCode;
	String message;
	String token;
	User user;

}
