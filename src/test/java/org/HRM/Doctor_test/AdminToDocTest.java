package org.HRM.Doctor_test;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.sdet40.genericUtility.BaseClass;
import org.sdet40.genericUtility.IConstantpath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminToDocTest extends BaseClass{
@Test
public void adminDocTest() throws EncryptedDocumentException, IOException, Exception {
String adminLoginUserName = excelUtil.getDataFromExcel(IConstantpath.EXCEL_PATH, "Admin",1 ,0 );
String adminLoginPassword = excelUtil.getDataFromExcel(IConstantpath.EXCEL_PATH, "Admin",1,1);
String docLoginUserName = excelUtil.getDataFromExcel(IConstantpath.EXCEL_PATH, "admin",2 ,0 );
String docLoginPassword = excelUtil.getDataFromExcel(IConstantpath.EXCEL_PATH, "Admin",2 ,1 );
String docName = excelUtil.getDataFromExcel(IConstantpath.EXCEL_PATH, "Admin",1,2);
String clinicAddress = excelUtil.getDataFromExcel(IConstantpath.EXCEL_PATH, "Admin",1 ,3);
String docFees= excelUtil.getDataFromExcel(IConstantpath.EXCEL_PATH, "Admin",1 ,4 );
String docContact=excelUtil.getDataFromExcel(IConstantpath.EXCEL_PATH, "Admin",1 ,5 );
String docEmail = excelUtil.getDataFromExcel(IConstantpath.EXCEL_PATH, "Admin",1 ,6 );
String docPassword = excelUtil.getDataFromExcel(IConstantpath.EXCEL_PATH, "Admin",1 ,7 );
String docConfirmPwd = excelUtil.getDataFromExcel(IConstantpath.EXCEL_PATH, "Admin",1 ,8 );
String updateDocFee = excelUtil.getDataFromExcel(IConstantpath.EXCEL_PATH, "Admin",2,4 );
String expectedResult = docName+random;
loginPage.clickAdmin();
loginPage.adminLoginActivity(adminLoginUserName,adminLoginPassword );
addDoc.docFeature();
addDoc.addDoctorFea();
WebElement element = addDoc.docspecialization();
webdriverUtil.selectClass(element, 2);
addDoc.addDoctor(random, docName, clinicAddress, docFees, docContact, random+docEmail, docPassword, docConfirmPwd);
webdriverUtil.swithToAlertWindowAndAccept(driver);
String fetchedtext = mngDocPge.getTextOfDynamicEle(expectedResult, driver);
Assert.assertEquals(fetchedtext, expectedResult);
}
}