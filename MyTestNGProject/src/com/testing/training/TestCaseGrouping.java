package com.testing.training;
import org.testng.annotations.Test;

public class TestCaseGrouping {

	@Test	(groups="Regression")
	public void testCaseOne() {
			System.out.println("I am in testCaseOne and in Regression groups");
			}
			@Test(groups="Regression")
	public void testCaseTwo() {
			System.out.println("I am in testCaseTwo and in Regression groups");
			}
			@Test(groups="Smoke Test")
	public void testCaseThree() {
			System.out.println("I am in testCaseThree and in Smoke Test groups");
			}
			@Test(groups={"Sanity","Regression","Smoke Test"})
	public void testCaseFour() {
			System.out.println("I am in testCaseFour and in Sanity,Regresion,Smoke Test groups");
			}

}
