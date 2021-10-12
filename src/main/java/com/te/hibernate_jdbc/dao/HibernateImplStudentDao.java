package com.te.hibernate_jdbc.dao;

import java.util.*;

import javax.persistence.*;

import com.te.hibernate_jdbc.dto.*;

public class HibernateImplStudentDao implements StudentDao {
	private static EntityManagerFactory factory=null;
	private static EntityManager manager=null;
	private static EntityTransaction transaction=null;
	private String fetchAll="from student";
	
	static {
		factory=Persistence.createEntityManagerFactory("hib");
		manager=factory.createEntityManager();
	}

	@Override
	public void insert(Student student) {
		transaction=manager.getTransaction();
		transaction.begin();
		manager.persist(student);
		transaction.commit();
	}

	@Override
	public void update(Student student) {
		transaction=manager.getTransaction();
		transaction.begin();
		manager.persist(student);
		transaction.commit();
	}

	@Override
	public void delete(Student student) {
		transaction=manager.getTransaction();
		transaction.begin();
		manager.remove(student);
		transaction.commit();
	}

	@Override
	public List<Student> fetchAll() {
		Query query= manager.createQuery(fetchAll);
		List<Student> list= query.getResultList();
		return list;
	}

	@Override
	public Student fetchSingle(int id) {
		Student student= manager.find(Student.class, id);
		return student;
	}

}
