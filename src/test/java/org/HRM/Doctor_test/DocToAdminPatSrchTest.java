package org.HRM.Doctor_test;

import java.io.IOException;

import org.HMS.objectRepository.PatientSearchInAdmin;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.sdet40.genericUtility.BaseClass;
import org.sdet40.genericUtility.IConstantpath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DocToAdminPatSrchTest extends BaseClass {
	@Test
	public void DocPatSrch() throws EncryptedDocumentException, IOException {
		String patientName = excelUtil.getDataFromExcel(IConstantpath.EXCEL_PATH, "PatientSearch", 1, 0);
		String patientContact = excelUtil.getDataFromExcel(IConstantpath.EXCEL_PATH, "PatientSearch", 1, 1);
		String patientEmail = excelUtil.getDataFromExcel(IConstantpath.EXCEL_PATH, "PatientSearch", 1, 2);
		String patientAddress = excelUtil.getDataFromExcel(IConstantpath.EXCEL_PATH, "PatientSearch", 1, 3);
		String patientAge = excelUtil.getDataFromExcel(IConstantpath.EXCEL_PATH, "PatientSearch", 1, 4);
		String patientMedicalHistory = excelUtil.getDataFromExcel(IConstantpath.EXCEL_PATH, "PatientSearch", 1, 5);
		String patientSearch = excelUtil.getDataFromExcel(IConstantpath.EXCEL_PATH, "PatientSearch", 1, 6);
		String expectedResult = patientName+random;
		loginPage.clickDoc();
		String docUsername = fileUtil.getPropertyKeyValue("doctorusername");
		String docPassword = fileUtil.getPropertyKeyValue("doctorpassword");
		String adminUsername = fileUtil.getPropertyKeyValue("adminusername");
		String adminPassword = fileUtil.getPropertyKeyValue("adminpassword");
		loginPage.docLoginActivity(docUsername, docPassword);
		docDashboard.patFeature();
		docDashboard.patientAdd();
		addPatientPage.addPatientActivity(random,patientName, patientContact, random+patientEmail, patientAddress, patientAge,patientSearch, patientMedicalHistory);
		addPatientPage.clickButton();
		commonPage.logoutActivity();
		loginPage.clickAdmin();
		loginPage.adminLoginActivity(adminUsername, adminPassword);
		String adminLoginUserName = excelUtil.getDataFromExcel(IConstantpath.EXCEL_PATH, "Admin", 1, 0);
		String adminLoginPassword = excelUtil.getDataFromExcel(IConstantpath.EXCEL_PATH, "Admin", 1, 1);
		patsrchAdmin.patSearchFea();
		managePatient.searchPattxt(patientName, random);
		managePatient.submitButton();
		String fetchedtext = managePatient.getTextOfDynamicEle(expectedResult, driver);
		Assert.assertEquals(fetchedtext, expectedResult);
	}
	}
