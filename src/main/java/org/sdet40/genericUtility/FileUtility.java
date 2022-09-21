package org.sdet40.genericUtility;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * This class consists reusable method to handle property file 
 * @author Harish
 *
 */
public class FileUtility {
/**
 * This method is used to fetch the data from property file
 * @return 
 * @throws IOException 
 */
	public String  getPropertyKeyValue(String key) throws IOException {
		FileInputStream fisProperty =new FileInputStream(IConstantpath.PROPERTY_FILE_PATH);
		Properties property=new Properties();
		property.load(fisProperty);
	String value=property.getProperty(key);
	return value;
	}
	public void initilalizePropertyFile() {
		
	}
}