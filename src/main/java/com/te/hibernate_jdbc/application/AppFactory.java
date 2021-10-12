package com.te.hibernate_jdbc.application;

import java.util.*;

import com.te.hibernate_jdbc.dao.*;

public class AppFactory {
	public static StudentDao getApp() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the type of implementation you want: ");
		String string = scanner.next();
		if (string.equalsIgnoreCase("Jdbc")) {
			return new JdbcImplStudentDao();
		} else if (string.equalsIgnoreCase("Hibernate")) {
			return new HibernateImplStudentDao();
		}else
			System.out.println("Invalid type entered....");
		return null;
	}
}
