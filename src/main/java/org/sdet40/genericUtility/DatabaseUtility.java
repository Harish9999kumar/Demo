package org.sdet40.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	Connection connection;

	public List<String> getDataFromDatabase(String query, String columnName) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(query);
		List<String> list = new ArrayList();
		while (result.next()) {
			list.add(result.getString(columnName));
		}
		return list;
	}

	public void openDBConnection(String dbUrl, String dbUserName, String dbPassword) throws SQLException {
		Driver dbDriver = new Driver();
		DriverManager.registerDriver(dbDriver);
		connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
	}

	public void closeDB() throws SQLException {
		connection.close();
	}

	public void modifyDataIntoDatabase(String query) throws SQLException {
		Statement statement = connection.createStatement();
		statement.executeUpdate(query);
	}

	public boolean verifyDataIntoDatabase(String query, String columnName, String expectedData) throws SQLException {
		List<String> list = getDataFromDatabase(query, columnName);
		boolean flag = false;
		for (String actualData : list) {
			if (actualData.equalsIgnoreCase(expectedData)) {
				flag = true;
				break;
			}
		}
		return flag;
	}
}