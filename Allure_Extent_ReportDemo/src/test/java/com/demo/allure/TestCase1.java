package com.demo.allure;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase1 {
  @Test
  public void testMethod1() {
	  
	  Assert.assertTrue(false);
	  System.out.println("testMethod1 is not working as expected");
  }
}
