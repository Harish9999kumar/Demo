package org.sdet40.practise;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.sdet40.genericUtility.ExcelUtility;
import org.sdet40.genericUtility.IConstantpath;

public class FetchDataFromExcelThroughListMap {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	ExcelUtility excelUtil=new ExcelUtility();
	excelUtil.openExcel(IConstantpath.EXCEL_PATH);
	List<Map<String, String>> list = excelUtil.getDataFromExcelInList("Form");
	System.out.println(list.get(2).get("FirstName"));
	Map<String, String> map = excelUtil.getDataFromExcelInMap("Form");
	System.out.println(map);
}
}
