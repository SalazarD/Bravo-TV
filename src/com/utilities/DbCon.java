package com.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DbCon {

	private static Connection con = null;

	private static final String userName = "root";

	private static final String password = "capstonekid";

	private static final String serverName = "localhost";

	private static final int portNumber = 3306;

	private static final String dbName = "ILP_CASE_STUDY";

	public static Connection getConnection()
	{
		if(con == null)
		{
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");

				Properties connectionProps = new Properties();
				connectionProps.put("user", userName);
				connectionProps.put("password", password);

				con = DriverManager.getConnection("jdbc:mysql://"+ serverName + ":" + portNumber + "/" + dbName + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", connectionProps);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return con;
	}

	public static void closeConnection()
	{
		try
		{
			if(con != null && !con.isClosed())
			{
				con.close();
			}
			con = null;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}