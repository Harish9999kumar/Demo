package org.sdet40.practise;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class MethodChaining {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/StudentDetails.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		DataFormatter d=new DataFormatter();
		try {
			Sheet sheet =wb.getSheet("Student Data");
			String data=d.formatCellValue(sheet.getRow(0).getCell(0));
			System.out.println(data);
			}
		finally {
			wb.close();	
		}
}
}