package com.te.hibernate_jdbc.application;

import com.te.hibernate_jdbc.dao.*;

public class AppTest {

	public static void main(String[] args) {
		AppDriver appDriver= new AppDriver();
		StudentDao iApp= AppFactory.getApp();
		appDriver.driver(iApp);
	}

}
