package com.te.hibernate_jdbc.application;

import com.te.hibernate_jdbc.dao.*;
import com.te.hibernate_jdbc.dto.Student;

public class AppDriver {
	public void driver(StudentDao dao) {
		Student student = null;
		int id = 0;
		dao.insert(student);
		dao.update(student);
		dao.delete(student);
		dao.fetchSingle(id);
		dao.fetchAll();
	}
}
