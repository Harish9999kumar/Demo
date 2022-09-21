package org.sdet40.practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// step1--> convert the physical file into java readable object
		FileInputStream fis = new FileInputStream("./src/test/resources/StudentDetails.xlsx");
		// step2 open the excel workbook
		Workbook wb = WorkbookFactory.create(fis);
		// step3 get the control on sheet
		Sheet s = wb.getSheet("Student Data");
		// step 4 get control on row
		Row r = s.getRow(0);
		// step 5 get control on cell
		Cell c = r.getCell(1);
		// step6 fetch the data
		String studentname = c.getStringCellValue();
		System.out.println(studentname);
		// step7 close the workbook
		wb.close();
		
		/*String data = wb.getSheet("Student Data").getRow(0).getCell(1).getStringCellValue();
		System.out.println(data);
		wb.close();*/
	}
}
