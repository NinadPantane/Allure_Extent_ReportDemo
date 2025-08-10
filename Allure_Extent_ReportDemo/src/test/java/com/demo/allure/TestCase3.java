package com.demo.allure;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestCase3 {
  @Test
  public void testMethod3() {
	  
	  throw new SkipException("testMethod3 is skipped");
  }
}
