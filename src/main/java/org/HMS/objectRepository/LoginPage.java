package org.HMS.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sdet40.genericUtility.WebdriverUtility;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// doctor Login
	@FindBy(xpath = "//h3[.='Doctors Login']/parent::div/descendant::a[.='Click Here']")
	private WebElement docLink;

	@FindBy(name = "username")
	private WebElement docUsnTxt;

	@FindBy(name = "password")
	private WebElement docPwdTxt;

	@FindBy(name = "submit")
	private WebElement docSubmit;
	// patient Login

	@FindBy(xpath = "//a[@href='hms/user-login.php']")
	private WebElement patLink;

	@FindBy(xpath = "//input[@name='username']")
	private WebElement patUsnTxt;

	@FindBy(name = "//input[@name='password']")
	private WebElement patPwdTxt;

	@FindBy(name = "submit")
	private WebElement patSubmit;

	// Admin Login

	@FindBy(xpath = "//a[@href='hms/admin']")
	private WebElement adminLink;

	@FindBy(name = "username")
	private WebElement adminUsnTxt;

	@FindBy(name = "password")
	private WebElement adminPwdTxt;

	@FindBy(name = "submit")
	private WebElement adminSubmit;
	
	// business Library

	public void docLoginActivity(String docuserName, String docpassword) {
		docUsnTxt.sendKeys(docuserName);
		docPwdTxt.sendKeys(docpassword);
		docSubmit.click();
	}
	public void adminLoginActivity(String adminUserName, String adminPassword) {
		adminUsnTxt.sendKeys(adminUserName);
		adminPwdTxt.sendKeys(adminPassword);
		adminSubmit.click();
	}

	public void patLoginActivity(String patUserName, String patPassword) {
		patUsnTxt.sendKeys(patUserName);
		patPwdTxt.sendKeys(patPassword);
		patSubmit.click();
	}
	public void clickDoc() {
		docLink.click();
	}
	public void clickAdmin() {
		adminLink.click();
	}
	public void clickPatient() {
		patLink.click();
	}
}
