package org.HMS.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sdet40.genericUtility.JavaUtility;

public class AddDoctorPage {

	public AddDoctorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[.=' Doctors ']")
	private WebElement docFea;
	@FindBy(xpath = "//span[text()=' Add Doctor']")
	private WebElement addDoc;
	@FindBy(name="Doctorspecialization")
	private WebElement docSpecialization;
	@FindBy (name="docname")
	private WebElement docNameTxt;
	@FindBy(name="clinicaddress")
	private WebElement clinicAddTxt;
	@FindBy(name="docfees")
	private WebElement docFeesTxt;
	@FindBy(name="doccontact")
	private WebElement docContTxt;
	@FindBy(id="docemail")
	private WebElement docMailTxt;
	@FindBy(name="npass")
	private WebElement pwdTxt;
	@FindBy(name="cfpass")
	private WebElement cfrmPwdTxt;
	@FindBy(id="submit")
	private WebElement submitBtn;
	@FindBy(name="docname")
	private WebElement docname;
	@FindBy(name="clinicaddress")
	private WebElement clinicAddr;
	@FindBy (name="docfees")
	private WebElement docFees;
	@FindBy(name="doccontact")
	private WebElement docCont;
	@FindBy(name="docemail")
	private WebElement docemail;
	@FindBy (name="npass")
	private WebElement pwd;
	@FindBy(name="cfpass")
	private WebElement cfrmpwd;
	@FindBy(name="submit")
	private WebElement submitBt;
	//business library
	public void docFeature() {
		docFea.click();
	}
	public void addDoctorFea() {
		addDoc.click();
	}
	public WebElement docspecialization() {
		return docSpecialization;
	}
	public void addDoctor(int randomNum,String docName,String clinicAddress,String docFeess,String docContact,String docEmail,String docPassword,String docConfirPwd) {
		docname.sendKeys(docName+randomNum);
		clinicAddr.sendKeys(clinicAddress);
		docFees.sendKeys(docFeess);
		docCont.sendKeys(docContact);
		docemail.sendKeys(docEmail);
		pwd.sendKeys(docPassword);
		cfrmpwd.sendKeys(docConfirPwd);
		submitBt.click();
	}
}
