package org.HRM.Doctor_test;

import java.io.IOException;

import org.sdet40.genericUtility.BaseClass;
import org.sdet40.genericUtility.IConstantpath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DocToAdminManagePatTest extends BaseClass{

	@Test
	public void patientSrchTest() throws IOException, InterruptedException {
		String patientName = excelUtil.getDataFromExcel(IConstantpath.EXCEL_PATH, "PatientSearch", 1, 0);
		String patientContact = excelUtil.getDataFromExcel(IConstantpath.EXCEL_PATH, "PatientSearch", 1, 1);
		String patientEmail = excelUtil.getDataFromExcel(IConstantpath.EXCEL_PATH, "PatientSearch", 1, 2);
		String patientAddress = excelUtil.getDataFromExcel(IConstantpath.EXCEL_PATH, "PatientSearch", 1, 3);
		String patientAge = excelUtil.getDataFromExcel(IConstantpath.EXCEL_PATH, "PatientSearch", 1, 4);
		String patientMedicalHistory = excelUtil.getDataFromExcel(IConstantpath.EXCEL_PATH, "PatientSearch", 1, 5);
		String patientSearch = excelUtil.getDataFromExcel(IConstantpath.EXCEL_PATH, "PatientSearch", 1, 6);
		String expectedResult = patientName+random;
		loginPage.clickDoc();
		loginPage.docLoginActivity(userName, password);
		docDashboard.patFeature();
		docDashboard.patientAdd(driver);
		addPatientPage.addPatientActivity(random, patientName, patientContact, patientEmail, patientAge, patientSearch, expectedResult, patientMedicalHistory);
		addPatientPage.clickButton();
		docDashboard.searchPatFeature();
		managePatient.searchPattxt(patientName, random);
		managePatient.submitButton();
		commonPage.logoutActivity();
		loginPage.clickAdmin();
		String adminLoginUserName = excelUtil.getDataFromExcel(IConstantpath.EXCEL_PATH, "Admin", 1, 0);
		String adminLoginPassword = excelUtil.getDataFromExcel(IConstantpath.EXCEL_PATH, "Admin", 1, 1);
	    loginPage.adminLoginActivity(adminLoginUserName, adminLoginPassword);
	    adminDashPage.adminPagePatient();
	    webdriverUtil.implicitwaitForElement();
	    adminDashPage.ManagePatInAdmin();
	    String fetchedtext = managePatient.getTextOfDynamicEle(expectedResult, driver);
		Assert.assertEquals(fetchedtext, expectedResult);
}
}