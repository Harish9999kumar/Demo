package org.sdet40.practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajio {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver= new ChromeDriver(option);
		driver.manage().window().maximize();
		 driver.get("https://www.ajio.com/");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 WebElement ele = driver.findElement(By.xpath("//a[text()='KIDS']"));
		 Actions a=new Actions(driver);
		 a.moveToElement(ele).perform();
		 driver.findElement(By.xpath("//a[text()='0-2 Years']")).click();
		 String productname = driver.findElement(By.xpath("//div[text()='0 To 2 Years']/following::div[text()='Jeans with Insert Pockets']")).getText();
		 String priceofproduct = driver.findElement(By.xpath("//div[text()='0 To 2 Years']/following::div[text()='Jeans with Insert Pockets']/following::span[text()='₹324']")).getText();
		 System.out.println(productname);
		 System.out.println(priceofproduct);
		 FileInputStream fis= new FileInputStream ("./src/test/resources/Book1.xlsx");
		 Workbook wb=WorkbookFactory.create(fis);
		 Sheet sheet = wb.getSheet("Ajio");
		 Cell cell = sheet.createRow(1).createCell(0);
		 cell.setCellValue(productname);
		 Workbook wb1=WorkbookFactory.create(fis);
		 Sheet sheet1 = wb.getSheet("Ajio");
		 Cell cell1 = sheet.createRow(1).createCell(1);
		 cell.setCellValue(priceofproduct);
		 FileOutputStream fos= new FileOutputStream("./src/test/resources/Book1.xlsx");
		 wb.write(fos);
		 }
}
