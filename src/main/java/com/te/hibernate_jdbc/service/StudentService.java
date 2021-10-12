package com.te.hibernate_jdbc.service;

import java.util.*;

import com.te.hibernate_jdbc.dto.*;

public interface StudentService {
	void insert(Student student);

	void update(int id);

	void delete(int id);

	List<Student> fetchAll();

	Student fetchSingle(int id);
}
