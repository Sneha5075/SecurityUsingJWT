package com.student.utils;

import java.util.Calendar;
import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.student.model.User;

public class Utils {
	public static Date now() {
		return new Date();
	}
	
	public static Date addMiliSec(Date time, int miliSec) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		cal.setTimeInMillis(System.currentTimeMillis() + miliSec);
		return cal.getTime();
	}
	
	
	public static String getTimestamp() {
		Date now = now();
		return Long.toHexString(now.getTime());
	}
	
}
