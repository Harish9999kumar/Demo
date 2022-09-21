package org.sdet40.practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HMS {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get("http://rmgtestingserver/domain/Hospital_Management_System/");
driver.findElement(By.xpath("//h3[text()='Admin Login']/following-sibling::div//a[text()='Click Here']")).click();
driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Test@12345");
driver.findElement(By.xpath("//button[@name='submit']")).click();
driver.findElement(By.xpath("//span[.=' Doctors ']")).click();
driver.findElement(By.xpath("//span[.=' Manage Doctors ']")).click();
 List<WebElement> headerList = driver.findElements(By.xpath("//table[@id='sample-table-1']/thead/tr/th"));
 List<WebElement> doctorNameList=new ArrayList<WebElement>();
 for(int i=0;i<headerList.size();i++) {
	 String headerName=headerList.get(i).getText();
	 if(headerName.equals("Doctor Name")) {
		 doctorNameList=driver.findElements(By.xpath("//table[@id=sample]-table-1']/tbody/tr/td["+(i+1)+"]"));
		 break;
	 }
 }
 for(WebElement doctor:doctorNameList) {
	 System.out.println(doctor.getText());
 }
}
}
