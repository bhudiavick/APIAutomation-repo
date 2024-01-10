package com.testing.training;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MultiTestDependency {

	@Test
	public void start() {
		Assert.assertEquals("John", "Paul");
		System.out.println("starting");
	}
	@Test(dependsOnMethods = "start")
	public void init() {
		System.out.println("initiallizing data");
		
	}
	@Test(dependsOnMethods = "init")
	public void process() {
		System.out.println("Processing data");
		
	}
	@Test(dependsOnMethods = "process")
	public void stopping() {
		System.out.println("Shutting down");
		
	}
}
