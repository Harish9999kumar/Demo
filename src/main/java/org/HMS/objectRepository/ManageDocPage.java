package org.HMS.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageDocPage {
public ManageDocPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(xpath = "//span[.=' Manage Doctors ']")
private WebElement mngDocFea;

String dynamic="//td[text()='%s']";

//business library
public void manageDocFea() {
	mngDocFea.click();
}
public String getTextOfDynamicEle(String replace,WebDriver driver) {
String reqwebele = String.format(dynamic, replace);
String dynamicText = driver.findElement(By.xpath(reqwebele)).getText();
return dynamicText;
}
}
