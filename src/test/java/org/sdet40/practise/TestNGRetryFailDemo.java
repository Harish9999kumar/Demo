package org.sdet40.practise;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGRetryFailDemo {
@Test
public void test1() {
	System.out.println("Im inside test1");
}
@Test()
public void test2() {
	System.out.println("Im inside test2");
	//int i=1/0;
}
@Test(retryAnalyzer = TestNGPractise.RetryAnalyser.class)
public void test3() {
	System.out.println("Im inside test3");
	//Assert.assertTrue(0>1);
}
}
