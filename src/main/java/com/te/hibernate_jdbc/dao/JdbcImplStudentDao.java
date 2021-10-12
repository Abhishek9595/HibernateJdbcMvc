package com.te.hibernate_jdbc.dao;

import java.sql.*;
import java.util.*;

import com.te.hibernate_jdbc.dto.Student;

public class JdbcImplStudentDao implements StudentDao {
	private static Connection connection = null;
	private static PreparedStatement preparedStatement = null;
	
	static {
		try {
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/hibernatejdbc?user=root&password=root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(Student student) {
		try {
			preparedStatement = connection.prepareStatement("insert into student values(?, ?, ?)");
			preparedStatement.setInt(1, student.getId());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setLong(3, student.getContact());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Student student) {
		try {
			preparedStatement = connection.prepareStatement("update student set name=?, contact=? where id=?");
			preparedStatement.setString(1, student.getName());
			preparedStatement.setLong(2, student.getContact());
			preparedStatement.setInt(3, student.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Student student) {
		try {
			preparedStatement = connection.prepareStatement("delete from student where id=?");
			preparedStatement.setInt(1, student.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Student> fetchAll() {
		List<Student> list = new ArrayList<Student>();
		try {
			preparedStatement = connection.prepareStatement("select * from student");
			list = (List<Student>) preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Student fetchSingle(int id) {
		Student student = null;
		try {
			preparedStatement = connection.prepareStatement("select * from student where id=?");
			preparedStatement.setInt(1, student.getId());
			student = (Student) preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

}
