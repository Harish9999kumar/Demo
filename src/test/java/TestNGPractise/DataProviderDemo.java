package TestNGPractise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderDemo {
@Test(dataProvider = "loginTestData")
public void TestLogin(String userName,String password) throws Exception {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://demo.actitime.com/login.do");
	driver.findElement(By.name("username")).sendKeys(userName);
	driver.findElement(By.name("pwd")).sendKeys(password);
	driver.findElement(By.xpath("//div[.='Login ']")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//a[.='Logout']")).click();
	driver.quit();
}
@DataProvider(name="loginTestData")
//@DataProvider
public Object[][] loginData() {
	//return new Object[][] {{"admin","manager"},{"admin","Test123"}};
	Object[][] data=new Object[2][2];
	data[0][0]="admin";
	data[0][1]="manager";
	
	data[1][0]="admin";
	data[1][1]="Test123";
	return data;
}
}
