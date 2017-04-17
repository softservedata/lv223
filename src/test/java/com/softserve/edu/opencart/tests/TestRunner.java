package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.appl.Application;
import com.softserve.edu.opencart.appl.ApplicationSourcesRepository;
import com.softserve.training.Calc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class TestRunner {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	// Use, if class Application is not singleton
	//protected Application application;

	@BeforeClass
	public void beforeClass() {
		System.out.println("@BeforeClass");
		System.out.println("***@BeforeClass MAVEN" + System.getProperty("surefire.reports.directory"));
		//application = new Application();
		Application.get(ApplicationSourcesRepository.getChromeCloud());
	}

	@AfterClass
	public void afterClass() {
		System.out.println("@AfterClass");
		Application.remove();
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("@BeforeMethod");
		//Application.get().load();
		//Application.get().login();
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("@AfterMethod");
		//Application.get().logout();
	}
}
