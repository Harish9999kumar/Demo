package TestNGPractise;

import org.sdet40.genericUtility.WebdriverUtility;
import org.testng.annotations.Test;

public class MavenPractiseTest {
@Test
public void stepTest() {
	String browser=System.getProperty("b");
	String url=System.getProperty("u");
	System.out.println("Browser name is "+browser);
	System.out.println("url is "+url);
}
}
