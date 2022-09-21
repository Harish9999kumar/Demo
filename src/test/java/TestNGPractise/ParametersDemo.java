package TestNGPractise;


import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class ParametersDemo {
@Test
@Parameters({"Qualification"})
public void test(String Qualification) {
	System.out.println("My qualification is "+Qualification);
}
}
