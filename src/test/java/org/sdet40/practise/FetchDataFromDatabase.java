package org.sdet40.practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.sdet40.genericUtility.DatabaseUtility;
import org.sdet40.genericUtility.IConstantpath;

import com.mysql.cj.jdbc.Driver;

public class FetchDataFromDatabase {
//	public static void main(String[] args) throws SQLException {
//		//step1: create the object for driver
//		Driver dbdriver=new Driver();
//		//step2: register the driver instance to the jdbc
//		DriverManager.registerDriver(dbdriver);
//		//step3:get/establish the database connection
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss","root","root");
//		try {
//			//step4: creating statement
//			Statement st = con.createStatement();
//			//step5: executing queries
//			ResultSet result = st.executeQuery("select * from sdet40;");
//			//step6: verify or itterate or fetch the data
//			while(result.next()) {
//				System.out.println(result.getString("address"));
//			}
//		}
//		finally {
//			//step7: close the database connection
//			con.close();// mandatory
//			System.out.println("connection closed successfully");
//		}
//	}
//
	public static void main(String[] args) throws SQLException {
		DatabaseUtility databaseUtil=new DatabaseUtility();
		databaseUtil.openDBConnection(IConstantpath.JDBC_URL_String, "root", "root");
		List<String> data1 = databaseUtil.getDataFromDatabase("select * from sdet40;", "emp_name");
		List<String> data2 = databaseUtil.getDataFromDatabase("select * from sdet40;", "emp_name");
		List<String> data3 = databaseUtil.getDataFromDatabase("select * from sdet40;", "emp_name");
		System.out.println(data1);
		System.out.println(data2);
		System.out.println(data3);
	}
}
