package org.HMS.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonPage {
	public CommonPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);	
	}
	@FindBy (xpath = "//span[@class='username']")
	private WebElement dropDownForLogout;
	@FindBy (xpath = "//a[contains(text(),'Log Out')]")
	private WebElement logout;
	//business library
	public void logoutActivity() {
		dropDownForLogout.click();
		logout.click();
	}
}
