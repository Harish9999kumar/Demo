package TestNGPractise;

import org.testng.annotations.Test;

public class GroupingsDemo {
	@Test(groups = "sanity")
	public void test1() {
		System.out.println("This is test1");
	}
	
	@Test(groups = {"sanity", "smoke" })
	public void test2() {
		System.out.println("This is test2");
	}

	@Test(groups = {"regression"})
	public void test3() {
		System.out.println("This is test3");
	}

	@Test
	public void test4() {
		System.out.println("This is test4");
	}
}
