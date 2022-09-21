package org.sdet40.practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Cell;

public class FetchDataToExcel {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	//step1->convert the physical file into java readable object
	FileInputStream fis=new FileInputStream("./src/test/resources/AddDataToExcel.xlsx");
	//step2--> open the excel workbook
	Workbook wb = WorkbookFactory.create(fis);
	//step3-->get the control on sheet
	 Sheet sheet=wb.getSheet("Sheet1");
	 //step4->get the control on row for new row
	 Row row =sheet.getRow(1);
	 //step5--> create the cell
	 Cell cell = row.createCell(3);
	 //step6--> update the status /set the data
	 cell.setCellValue("skip");
	 FileOutputStream fos=new FileOutputStream("./src/test/resources/AddDataToExcel.xlsx");
	 //step7-->write the data into excel
	 wb.write(fos);
	 System.out.println("Data updated successfully");
	 //step8-->close the workbook
	 wb.close();
}
}
