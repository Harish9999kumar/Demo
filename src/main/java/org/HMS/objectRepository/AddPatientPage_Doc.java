package org.HMS.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sdet40.genericUtility.JavaUtility;

public class AddPatientPage_Doc {
	public AddPatientPage_Doc(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="patname")
	private WebElement patNameTxt;
	@FindBy (name="patcontact")
	private WebElement patContactTxt;
	@FindBy (name="patemail")
	private WebElement patEmailTxt;
	@FindBy (xpath = "//label[@for='rg-male']")
	private WebElement patgenderTxt;
	@FindBy (name="pataddress")
	private WebElement pataddressTxt;
	@FindBy (name="patage")
	private WebElement patageTxt;
	@FindBy (name="medhis")
	private WebElement patmedhisTxt;
	@FindBy(name="submit")
	private WebElement addBtn;
	@FindBy(xpath = "//label[@for='rg-male']")
	private WebElement radioBtn;
	//business library
	public void addPatientActivity(int randomNum, String patName,String patContact,String emailTxt,String genderText,String adressTxt,String ageTxt,String medicalHistory) {
		patNameTxt.sendKeys(patName+randomNum);
		patContactTxt.sendKeys(patContact);
		patEmailTxt.sendKeys(JavaUtility.getRanDomNum(1000)+emailTxt);
		radioBtn.click();
		pataddressTxt.sendKeys(adressTxt);
		patageTxt.sendKeys(ageTxt);
		patmedhisTxt.sendKeys(medicalHistory);
		addBtn.click();
		
	}
	public void clickButton() {
		addBtn.click();
}
	public void genderRadioBtn() {
		radioBtn.click();
	}
	}
