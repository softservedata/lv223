package com.softserve.edu.opencart;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {

	@Test
	public void testApp() {
		System.out.println("surefire.reports.directory = " 
				+ System.getProperty("surefire.reports.directory"));
		System.out.println("selenium-version = " 
				+ System.getProperty("selenium-version"));
		System.out.println("***Test Done***");
		Assert.assertTrue(true);
	}

}
