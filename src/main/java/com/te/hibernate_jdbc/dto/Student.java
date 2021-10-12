package com.te.hibernate_jdbc.dto;

import java.io.*;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Student implements Serializable {
	@Id
	private int id;
	private String name;
	private long contact;
	public Student(int id, String name, long contact) {
		this.id=id;
		this.name = name;
		this.contact = contact;
	}
}
