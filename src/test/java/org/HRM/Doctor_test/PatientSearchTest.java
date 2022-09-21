package org.HRM.Doctor_test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.sdet40.genericUtility.BaseClass;
import org.sdet40.genericUtility.IConstantpath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PatientSearchTest extends BaseClass {
	@Test(retryAnalyzer=org.sdet40.genericUtility.RetryImpClass.class)
	public void patientSrchTest() throws IOException, InterruptedException {
		String patientName = excelUtil.getDataFromExcel(IConstantpath.EXCEL_PATH, "PatientSearch", 1, 0);
		String patientContact = excelUtil.getDataFromExcel(IConstantpath.EXCEL_PATH, "PatientSearch", 1, 1);
		String patientEmail = excelUtil.getDataFromExcel(IConstantpath.EXCEL_PATH, "PatientSearch", 1, 2);
		String patientAddress = excelUtil.getDataFromExcel(IConstantpath.EXCEL_PATH, "PatientSearch", 1, 3);
		String patientAge = excelUtil.getDataFromExcel(IConstantpath.EXCEL_PATH, "PatientSearch", 1, 4);
		String patientMedicalHistory = excelUtil.getDataFromExcel(IConstantpath.EXCEL_PATH, "PatientSearch", 1, 5);
		loginPage.clickDoc();
		loginPage.docLoginActivity(userName, password);
		String expectedResult = patientName+random;
		docDashboard.patFeature();
		docDashboard.patientAdd();
		addPatientPage.addPatientActivity(random,patientName, patientContact, patientEmail, patientAddress, patientAge,expectedResult, patientMedicalHistory);
		addPatientPage.clickButton();
		docDashboard.searchPatFeature();
		managePatient.searchPattxt(patientName, random);
		managePatient.submitButton();
		String fetchedtext = managePatient.getTextOfDynamicEle(expectedResult, driver);
		Assert.assertEquals(fetchedtext, expectedResult);
	}
}
