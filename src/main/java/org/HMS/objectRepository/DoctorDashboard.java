package org.HMS.objectRepository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DoctorDashboard {
	
	public DoctorDashboard(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//span[.=' Patients ']")
	private WebElement patientFeature;
	@FindBy(xpath = "//span[.=' Add Patient']")
	private WebElement addPatient;
	@FindBy (xpath = "//span[.=' Search ']")
	private WebElement searchFeature;
	@FindBy(xpath = "//a[contains(text(),'Update Profile')]")
	private WebElement updateFeaturee;
	@FindBy(xpath = "//a[@href='manage-patient.php']/span[.=' Manage Patient ']")
	private WebElement manageFeature;
	//business library
	public void patientAdd(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(addPatient));
		addPatient.click();
		}
	public void patientAdd() {
		addPatient.click();
	}
	public void searchPatFeature() {
		searchFeature.click();
	}
	public void patFeature() {
		patientFeature.click();
	}
	public void docUpdateFea() {
		updateFeaturee.click();
	}
	public void managePat() {
		manageFeature.click();
	}
	

	
}
