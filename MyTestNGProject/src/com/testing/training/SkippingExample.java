package com.testing.training;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class SkippingExample {

    @Test(enabled = false)
    public void testOne() {
        System.out.println("Hi, I am Test One");
    }

    @Test
    public void testTwo() {
        System.out.println("Hi, I am Test Two");
        throw new SkipException("Skipped delibretly");
    }

    @Test
    public void testThree() {
        System.out.println("Hi, I am Test Three");
    }

    @Test
    public void testFour() {
        System.out.println("Hi, I am Test Four");
    }
}