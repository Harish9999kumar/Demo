package org.sdet40.practise;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.google.j2objc.annotations.Property;

public class FetchDataFromPropertyFile {
public static void main(String[] args) throws IOException {
	//step1 convert physical file into java readable java object
	FileInputStream fis=new FileInputStream("./src/test/resources/commondata.properties");
	//step2 create object to properties();
	Properties p=new Properties();
	//step3 load all the keys
	p.load(fis);
	//step4 fetch data
	String url=p.getProperty("Url").trim();
	String username=p.getProperty("Username").trim();
	System.out.println(url);
	System.out.println(username);
}
}
