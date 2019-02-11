package dataDriven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import config.Constant;

public class DBConnect {
	
	public static  Connection con = null;
	public static Statement stmt = null;
	static String baseUrl;
	static ResultSet resultSet = null;
	static String resultValue = "";

	
	public static String getDataFromDataBase(String query) {
		

		try {
			resultValue = null;
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = Constant.DBServerName;
			con = DriverManager.getConnection(url,Constant.DBLoginUserName,Constant.DBLoginPassword);
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(query);

			while (resultSet.next()) {
				resultValue = resultSet.getString(1).toString();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultValue;

	}


}
