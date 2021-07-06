package com.student.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {

	Integer httpStatusCode;
	String message;
	Object result;

}
