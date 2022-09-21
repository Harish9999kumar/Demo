package org.HMS.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Doc_ManagePatientsPage {
	public Doc_ManagePatientsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name ="searchdata" )
	private WebElement searchTxt;
	@FindBy (id = "submit")
	private WebElement submitBtn;
	
	String dynamic="//td[.='%s']";
	
	//business library
	public void searchPattxt(String patName,int randomNum) {
		searchTxt.sendKeys(patName+randomNum);
	}
	public void submitButton() {
		submitBtn.click();
	}
	public String getTextOfDynamicEle(String replace,WebDriver driver) {
	String reqwebele = String.format(dynamic, replace);
	String dynamicText = driver.findElement(By.xpath(reqwebele)).getText();
	return dynamicText;
	}
}
