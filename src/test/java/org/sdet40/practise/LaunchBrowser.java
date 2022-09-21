package org.sdet40.practise;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {
	public static void main(String [] args) {
		String browser="chrome";
		WebDriver driver=null;

		/*if(browser.equalsIgnoreCase("FireFox")) {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	else if(browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else if(browser.equalsIgnoreCase("ie")) {
		WebDriverManager.iedriver().setup();
		driver=new InternetExplorerDriver();
	}
	else {
		System.out.println("Please enter valid browser");
	}*/
		switch(browser) {
		case "FireFox":WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		break;
		case "chrome":WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		break;
		case "ie":WebDriverManager.iedriver().setup();
		driver=new InternetExplorerDriver();
		break;
		default: System.out.println("Please enter valid browser key");
		break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		driver.get("//http://localhost:8888");
	}
}
