package org.hyr.parallelTest;

import org.sdet40.genericUtility.IConstantpath;
import org.testng.annotations.Test;

public class TestClass1 {
@Test
public void testMethod1() {
	System.out.println("Testcase1 >> testMethod1 >>"+Thread.currentThread().getId());
}
@Test
public void testMethod2() {
	System.out.println("Testcase1 >> testMethod2 >>"+Thread.currentThread().getId());
}
@Test
public void testMethod3() {
	System.out.println("Testcase1 >> testMethod3 >>"+Thread.currentThread().getId());
}
@Test
public void testMethod4() {
	System.out.println("Testcase1 >> testMethod4 >>"+Thread.currentThread().getId());
}
}
