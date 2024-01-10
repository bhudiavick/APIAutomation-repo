package com.testing.training;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class AssertionExample {
			@Test
			public void testOne() {
			System.out.println("Hi I am Test One");
			assertEquals("Facebook", "Facebook");
			}
			@Test
			public void testTwo() {
			
			assertEquals(404, 200);
			System.out.println("Hi, I am Test TwO will not print as it is a hard assertion");
			}
			@Test
			public void testThree(){
			System.out.println("Hi, I am Test Three");
			assertTrue(true);
			}
			@Test 
			public void testFour() {
			System.out.println("Hi, I am Test Four");
			assertFalse(true,"Making this fail as it should expect false");
			}
			@Test
			public void testFive(){
			System.out.println("Hi, I am Test Five");
			}
			@Test
			public void testsix() {
			System.out.println("Hi, I am Test Sixs");
			}
}
