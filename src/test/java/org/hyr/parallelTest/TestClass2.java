package org.hyr.parallelTest;

import org.testng.annotations.Test;

public class TestClass2 {
	@Test
	public void testMethod5() {
		System.out.println("Testcase2 >> testMethod5 >>"+Thread.currentThread().getId());
	}
	@Test
	public void testMethod6() {
		System.out.println("Testcase2 >> testMethod6>>"+Thread.currentThread().getId());
	}
	@Test
	public void testMethod3() {
		System.out.println("Testcase2 >> testMethod7>>"+Thread.currentThread().getId());
	}
	
}
