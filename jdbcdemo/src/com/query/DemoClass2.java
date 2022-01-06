package com.query;
import java.sql.*;
public class DemoClass2 {
	public static void main(String[] args) throws Exception
	{
		String url = "jdbc:mysql://127.0.0.1:3306/aliens";
		String uname = "SQL";
		String pass = "lqs";
		int userid = 6;
		String username = "rashi";
		String query = "insert into student values(?,?)";  //when u want to work with predefined query(means query fixed) but value will keep changing--use PreparedStatement 
		//String query = "insert into student values(5,'rohan')";
		//String query = "insert into student values("+userid+",'"+username+"')";
		//Class.forName("com.mysql,jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		PreparedStatement st = con.prepareStatement(query); //PreparedStatement
		st.setInt(1, userid);
		st.setString(2, username);
		int count = st.executeUpdate(); // DDL, DML, DQL
		
		
		
		System.out.println(count + " row/s affected");
		
		st.close();
		con.close();
	}
}

