package com.te.hibernate_jdbc.dao;

import java.util.List;

import com.te.hibernate_jdbc.dto.Student;

public interface StudentDao {
	void insert(Student student);

	void update(Student student);

	void delete(Student student);

	List<Student> fetchAll();

	Student fetchSingle(int id);
}
