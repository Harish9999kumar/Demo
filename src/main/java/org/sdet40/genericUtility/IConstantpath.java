package org.sdet40.genericUtility;

import java.time.Duration;

/**
 * This interface consists of all the external file paths
 * 
 * @author Harish
 *
 */
public interface IConstantpath {
//variable, method name=camelcase
//Interface, class, enum,annotion=pascal case
//static final-->capital
	String PROJECT_PATH = System.getProperty("user.dir");
	String EXCEL_PATH = PROJECT_PATH + "/src/test/resources/HMS.xlsx";
	String PROPERTY_FILE_PATH = PROJECT_PATH +"/src/test/resources/commondata.properties";
	String JDBC_URL_String = "jdbc:mysql://localhost:3306/tyss";
	String JDBC_USERNAME = "root";
	String JDBC_PASSWORD = "root";
	int Implicitly_TIMEOUT = 10;
	int Explicitly_TIMEOUT = 20;
}
