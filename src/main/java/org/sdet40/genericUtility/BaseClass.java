package org.sdet40.genericUtility;

import java.io.IOException;

import org.HMS.objectRepository.AddDoctorPage;
import org.HMS.objectRepository.AddPatientPage_Doc;
import org.HMS.objectRepository.AdminDashboardPage;
import org.HMS.objectRepository.CommonPage;
import org.HMS.objectRepository.DocUpdateProfPage;
import org.HMS.objectRepository.Doc_ManagePatientsPage;
import org.HMS.objectRepository.DoctorDashboard;
import org.HMS.objectRepository.LoginPage;
import org.HMS.objectRepository.ManageDocPage;
import org.HMS.objectRepository.PatientSearchInAdmin;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseClass {
	protected WebDriver driver;
	protected String userName;
	protected String password;
	protected String url;
	protected String browser;
	protected JavaUtility javaUtil;
	protected WebdriverUtility webdriverUtil;
	protected ExcelUtility excelUtil;
	protected FileUtility fileUtil;
	protected CommonPage commonPage;
	protected AddPatientPage_Doc addPatientPage;
	protected Doc_ManagePatientsPage managePatient;
	protected DoctorDashboard docDashboard;
	protected LoginPage loginPage;
	protected AdminDashboardPage adminDashPage;
	protected AddDoctorPage addDoc;
	protected DocUpdateProfPage docUpdatefee;
	protected int random;
	protected PatientSearchInAdmin patsrchAdmin;
	protected DoctorDashboard docDash;
	protected ManageDocPage mngDocPge;
	public static WebDriver sdriver;
	public static JavaUtility sjavaUtil;

	@BeforeClass
	public void configBC() throws IOException {
		javaUtil = new JavaUtility();
		webdriverUtil = new WebdriverUtility();
		excelUtil = new ExcelUtility();
		fileUtil = new FileUtility();
		sdriver=driver;
		userName = fileUtil.getPropertyKeyValue("doctorusername");
		password = fileUtil.getPropertyKeyValue("doctorpassword");
		url = fileUtil.getPropertyKeyValue("url");
		browser = fileUtil.getPropertyKeyValue("browser");
		// launching the browser
		driver = webdriverUtil.commonForAll(browser, url);
		sjavaUtil=javaUtil;
		addPatientPage = new AddPatientPage_Doc(driver);
		managePatient = new Doc_ManagePatientsPage(driver);
		docDashboard = new DoctorDashboard(driver);
		loginPage = new LoginPage(driver);
		
		random = javaUtil.getRanDomNum(1000);
		adminDashPage = new AdminDashboardPage(driver);
		addDoc = new AddDoctorPage(driver);
		commonPage = new CommonPage(driver);
		docUpdatefee = new DocUpdateProfPage(driver);
		commonPage = new CommonPage(driver);
		patsrchAdmin = new PatientSearchInAdmin(driver);
		docDash = new DoctorDashboard(driver);
		mngDocPge=new ManageDocPage(driver);
	}

	@AfterClass
	public void configAC() {
		driver.quit();
	}
}
