package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtility {
	public static final String username = "root";
	public static final String password = "";
	public static final String url = "jdbc:mysql://localhost:3306/demodb";
	public static Connection con;
	
	public static Connection DBConnectivity()
	{
		try {
			if(con!=null)
			{
				return con;
			}
			else {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url,username,password);
			}
		}catch(Exception e)
		{
			System.out.println("Exception occured in connection "+e);
		}
		return con;
	}
}
