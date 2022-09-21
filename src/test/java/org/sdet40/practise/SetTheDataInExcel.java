package org.sdet40.practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class SetTheDataInExcel {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("./src/test/resources/StudentDetails.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	wb.getSheet("Student Data").getRow(1).getCell(1).setCellValue("Banglaore Technological Institute");
	FileOutputStream fos=new FileOutputStream("./src/test/resources/StudentDetails.xlsx");
	wb.write(fos);
	wb.close();
}
}
