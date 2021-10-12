package com.te.hibernate_jdbc.main;

import java.util.*;

import com.te.hibernate_jdbc.dto.Student;
import com.te.hibernate_jdbc.service.*;

public class AppMain {
	private static int id;
	private static String name;
	private static long contact;
	private static boolean exit;
	private static StudentService hibService= new HibernateImplStudentService();
	private static StudentService jdbcService= new JdbcImplStudentService();

	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		System.out.println("Enter the implementation: hibernate/jdbc");
		String string= scanner.next().toLowerCase();
		System.out.println("Press 1 to insert\n"
				+ "Press 2 to display all data\nPress 3 to display by id\nPress 4 to update\n"
				+ "Press 5 to delete\nPress 6 to exit");
		if(string.equalsIgnoreCase("hibernate")) {
			System.out.println("Welcome to hibernate implementation!!");
			while(!exit) {
			String character=scanner.next();	
			switch (character) {
			case "1":
				System.out.println("Enter the id, name and contact: ");
				id=scanner.nextInt();
				name=scanner.next();
				contact=scanner.nextLong();
				hibService.insert(new Student(id, name, contact));
				System.out.println("Data inserted!!");
				System.err.println("Do you want to continue: y/n");
				break;
			case "2":
				List<Student> list=hibService.fetchAll();
				for (Student student : list) {
					System.out.println(student);
				}
				break;
			case "3":
				System.out.println("Enter the id: ");
				id=scanner.nextInt();
				System.out.println(hibService.fetchSingle(id));
				System.err.println("Do you want to continue: y/n");
				break;
			case "4":
				System.out.println("Enter the id: ");
				id=scanner.nextInt();
				hibService.update(id);
				System.out.println("Updated!!");
				System.err.println("Do you want to continue: y/n");
				break;
			case "5":
				System.out.println("Enter the id: ");
				id=scanner.nextInt();
				hibService.delete(id);
				System.out.println("Deleted!!");
				System.err.println("Do you want to continue: y/n");
				break;
			case "y":
				System.out.println("Press 1 to insert\n"
						+ "Press 2 to display all data\nPress 3 to display by id\nPress 4 to update\n"
						+ "Press 5 to delete\nPress 6 to exit");
				break;
			case "n":
				System.err.println("Exited the application!!");
				exit=true;
				break;
			case "6":
				System.err.println("Exited the application!!");
				exit=true;
				break;
			default:
				System.out.println("Enter correctly!!");
				break;
			}
			}
		}else if (string.equalsIgnoreCase("jdbc")) {
			System.out.println("Welcome to jdbc implementation!!");
			while(!exit) {
				String character=scanner.next();
				switch (character) {
				case "1":
					System.out.println("Enter the id, name and contact: ");
					id=scanner.nextInt();
					name=scanner.next();
					contact=scanner.nextLong();
					jdbcService.insert(new Student(id, name, contact));
					System.out.println("Data inserted!!");
					System.err.println("Do you want to continue: y/n");
					break;
				case "2":
					List<Student> list=jdbcService.fetchAll();
					for (Student student : list) {
						System.out.println(student);
					}
					break;
				case "3":
					System.out.println("Enter the id: ");
					id=scanner.nextInt();
					System.out.println(jdbcService.fetchSingle(id));
					System.err.println("Do you want to continue: y/n");
					break;
				case "4":
					System.out.println("Enter the id: ");
					id=scanner.nextInt();
					jdbcService.update(id);
					System.out.println("Updated!!");
					System.err.println("Do you want to continue: y/n");
					break;
				case "5":
					System.out.println("Enter the id: ");
					id=scanner.nextInt();
					jdbcService.delete(id);
					System.out.println("Deleted!!");
					System.err.println("Do you want to continue: y/n");
					break;
				case "y":
					System.out.println("Press 1 to insert\n"
							+ "Press 2 to display all data\nPress 3 to display by id\nPress 4 to update\n"
							+ "Press 5 to delete\nPress 6 to exit");
					break;
				case "n":
					System.err.println("Exited the application!!");
					exit=true;
					break;
				case "6":
					System.err.println("Exited the application!!");
					exit=true;
					break;
				default:
					System.out.println("Enter correctly!!");
					break;
				}
			}
		}
	}

}
