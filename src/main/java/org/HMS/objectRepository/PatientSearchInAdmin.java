package org.HMS.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientSearchInAdmin {
public PatientSearchInAdmin(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
	@FindBy(xpath ="//span[.=' Patient Search ']" )
	private WebElement patientsrch;
	@FindBy(id="searchdata")
	private WebElement searchData;
	@FindBy (id="submit")
	private WebElement submitBtn;
	
	//business library
	public void patSearchFea() {
		patientsrch.click();
	}
	
	public void submitBtnn() {
		submitBtn.click();
	}

}
