package com.onmobile.rbt.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.onmobile.rbt.common.BaseClass;

public class MyFirstSeleniumClass extends BaseClass {

	@Test
	public void VerifyTitle() {
		driver.get(System.getProperty("url"));
		String title = driver.getTitle();
		Assert.assertEquals(title, "Human Resources Management Software | OrangeHRM1");
	}

	@Test
	public void VerifyTitle1() {
		driver.get(System.getProperty("url"));
		String title = driver.getTitle();
		Assert.assertEquals(title, "Human Resources Management Software | OrangeHRM1");
	}

	@Test
	public void VerifyTitle2() {
		driver.get(System.getProperty("url"));
		String title = driver.getTitle();
		Assert.assertEquals(title, "Human Resources Management Software | OrangeHRM1");
	}
	
	@Test
	public void VerifyTitle3() {
		driver.get(System.getProperty("url"));
		String title = driver.getTitle();
		Assert.assertEquals(title, "Human Resources Management Software | OrangeHRM");
	}
}
