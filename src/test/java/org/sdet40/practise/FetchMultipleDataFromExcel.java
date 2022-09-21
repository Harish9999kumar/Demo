package org.sdet40.practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchMultipleDataFromExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/ExcelFetchDataKey.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		 Sheet s = wb.getSheet("Sheet1");
		DataFormatter df=new DataFormatter();
		for(int i=0;i<=s.getLastRowNum();i++) {
			for(int j=0;j<s.getRow(i).getLastCellNum();j++) {
				System.out.println(df.formatCellValue(s.getRow(i).getCell(j))+" || ");
			}
			System.out.print(" ");
		}
	}
}
