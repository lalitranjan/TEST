package com.demo.jdbc;
import java.sql.*;
public class UpdateStatement {
	public static void main(String[] args) throws Exception
	{
		String url = "jdbc:mysql://127.0.0.1:3306/task";
		String uname = "SQL";
		String pass = "lqs";
		int id = 211;
		String firstname = "sachin";
		String query = "update student SET firstname=sachin where id=211 ";  //when u want to work with predefined query(means query fixed) but value will keep changing--use PreparedStatement 
		//String query = "insert into student values(5,'rohan')";
		//String query = "insert into student values("+userid+",'"+username+"')";
		//Class.forName("com.mysql,jdbc.Driver");
		try {
			Connection con = DriverManager.getConnection(url,uname,pass);
			PreparedStatement st = con.prepareStatement(query); //PreparedStatement
			st.setInt(0, id);
			st.setString(1, firstname);
			int count = st.executeUpdate(); // DDL, DML, DQL
			System.out.println(count + " row/s affected");
			
			st.close();
			con.close();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}
	


