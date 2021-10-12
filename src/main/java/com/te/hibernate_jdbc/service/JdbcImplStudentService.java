package com.te.hibernate_jdbc.service;

import java.util.*;

import com.te.hibernate_jdbc.dao.*;
import com.te.hibernate_jdbc.dto.*;

public class JdbcImplStudentService implements StudentService {

	StudentDao dao = new JdbcImplStudentDao();
	Scanner scanner = new Scanner(System.in);

	@Override
	public void insert(Student student) {
		if (student != null)
			dao.insert(student);
	}

	@Override
	public void update(int id) {
		Student student = fetchSingle(id);
		if (id > 0 && student != null) {
			System.out.println("update name: y/n");
			String string = scanner.next();
			if (string.equalsIgnoreCase("y")) {
				System.out.println("Enter the name: ");
				student.setName(scanner.next());
			}
			System.out.println("update contact: y/n");
			String string2 = scanner.next();
			if (string2.equalsIgnoreCase("y")) {
				System.out.println("Enter the contact: ");
				student.setContact(scanner.nextLong());
			}
			dao.update(student);
		}
	}

	@Override
	public void delete(int id) {
		Student student = fetchSingle(id);
		if (id > 0 && student != null)
			dao.delete(student);
	}

	@Override
	public List<Student> fetchAll() {
		return dao.fetchAll();
	}

	@Override
	public Student fetchSingle(int id) {
		if (id > 0)
			return dao.fetchSingle(id);
		return null;
	}

}
