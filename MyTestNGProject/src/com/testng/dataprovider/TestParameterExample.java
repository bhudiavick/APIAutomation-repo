package com.testng.dataprovider;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@Test(dataProvider = "DoubleSet") //or use methodName
public class TestParameterExample {
	
	public void testAddition(int actual, int expected) {
		int actualValue = actual + 20;
		
		Assert.assertEquals(actualValue, expected);
	}
	
	@DataProvider
	public Object[][] getData(){
		return new Object[][] {
			{100,120},
			{200,220},
			{250,270},
			{300,310},
			{400,420}
		};
	}
	
	@DataProvider(name = "DoubleSet")
	public Object[][] getDataSet(){
		return new Object[][] {
			{10,30},
			{20,40}
		};
	}
	
}

