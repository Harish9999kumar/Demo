package org.HMS.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientDashboard {
	public PatientDashboard(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@href='book-appointment.php']")
	private WebElement bookAppointmentFeature;
	
	//business library
	public void bookAppoint() {
		bookAppointmentFeature.click();
	}
}
