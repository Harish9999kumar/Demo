package org.HMS.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookAppointmentPage {
	public BookAppointmentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="Doctorspecialization")
	private WebElement docSpecializationTxt;
	@FindBy(id="doctor")
	private WebElement docNameTxt;
	@FindBy(xpath="//input[@name='appdate']")
	private WebElement appointDateTxt;
	@FindBy(xpath="//td[.='30']")
	private WebElement dateTxt;
	@FindBy (xpath = "//input[@id='timepicker1']")
	private WebElement timepicker1;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submitBtn;
	@FindBy(xpath = "//span[contains(.,' Dashboard ')]")
	private WebElement dashboard;
	@FindBy(xpath = "//span[.=' Appointment History ']")
	private WebElement appointHistory;
}
