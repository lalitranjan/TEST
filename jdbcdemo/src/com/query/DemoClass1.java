package com.query;
//how to fetch the whole table from database using jdbc
import java.sql.*;
public class DemoClass1 {
	public static void main(String[] args) throws Exception
	{
		String url = "jdbc:mysql://127.0.0.1:3306/aliens";
		String uname = "SQL";
		String pass = "lqs";
		String query = "select * from student";
		
		//Class.forName("com.mysql,jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		String userData = "";
		
		while(rs.next())
		{
			userData = rs.getInt(1)+":"+rs.getString(2);
			System.out.println(userData);
		}
		
		
		/*
		 * rs.next(); userData = rs.getInt(1)+":"+rs.getString(2);
		 * System.out.println(userData);
		 * 
		 * rs.next(); userData = rs.getInt(1)+":"+rs.getString(2);
		 * System.out.println(userData);
		 */
		st.close();
		con.close();
	}
}
