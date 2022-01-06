package com.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlDemo {
	static final String url = "jdbc:mysql://127.0.0.1:3306/task";
	static final String uname = "SQL";
	static final String pass = "lqs";
			
	public static void main(String[] args) throws Exception
	{
		try
		{
			//Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,uname,pass);
			Statement st = con.createStatement();
			st.executeUpdate("drop table student");
			st.executeUpdate("create table student(id int NOT NULL,FirstName varchar(50) NOT NULL,LastName varchar(50),address varchar(100) NOT NULL,contactNumber long NOT NULL,Primary Key(id))");   
			st.addBatch("insert into student values(200,'ankit','kumar','NY',1234567)");
			st.addBatch("insert into student values(201,'sourav','kumar','LA',1234568)");
			st.addBatch("insert into student values(202,'sam','kumar','LA',1834569)");
			st.addBatch("insert into student values(203,'rohan','kumar','NY',1934569)");
			st.addBatch("insert into student values(204,'rahul','kumar','NY',1634569)");
			st.addBatch("insert into student values(205,'ankit','kumar','NY',1734569)");
			st.addBatch("insert into student values(206,'sohan','kumar','LV',1334569)");
			st.addBatch("insert into student values(207,'rohit','kumar','LA',1234569)");
			st.addBatch("insert into student values(208,'mohan','kumar','NY',1234569)");
			st.addBatch("insert into student values(209,'kapil','kumar','LV',1234569)");
			st.addBatch("insert into student values(210,'ankit','kumar','NY',1284569)");
			st.addBatch("insert into student values(211,'jai','kumar','LV',1234569)");
			st.addBatch("insert into student values(212,'annu','kumar','NY',1234868)");
			st.addBatch("insert into student values(213,'shahil','kumar','LA',1237569)");
			st.addBatch("insert into student values(214,'sumit','kumar','NY',1239569)");
			st.addBatch("insert into student values(215,'ankit','kumar','NY',1235569)");
			st.addBatch("insert into student values(216,'amit','kumar','LA',1236569)");
			st.addBatch("insert into student values(217,'raj','kumar','LV',1231569)");
			st.addBatch("insert into student values(218,'sanu','kumar','NY',1214569)");
			st.addBatch("insert into student values(219,'nishant','kumar','LV',1244569)");
			st.addBatch("insert into student values(220,'ankit','kumar','NY',1134569)");
			st.executeBatch();
			
			String sql ="Select * from student where id=215";
			ResultSet r = st.executeQuery(sql);
			while (r.next())
			{
				System.out.print(r.getInt(1)+ " ");
				System.out.print(r.getString(2)+ " ");
				System.out.print(r.getInt(5)+ " ");
				System.out.println();
			}
			
			String sql1 ="Select * from student where firstname='ankit'";
			ResultSet r1 = st.executeQuery(sql1);
			while (r1.next())
			{
				System.out.println();
				System.out.print(r1.getInt(1)+ " ");
				System.out.print(r1.getString(2)+ " ");
				System.out.print(r1.getInt(5)+" ");
			}
			
			
			long num = 1231569;
			String sql2= "update student set firstname = 'Modi' where contactnumber= "+num;
			st.executeUpdate(sql2);
			ResultSet r2 = st.executeQuery("select * from student where contactnumber = "+num);
			while (r2.next())
			{
				System.out.println();
				System.out.print(r2.getInt(1)+ " ");
				System.out.print(r2.getString(2)+ " ");
				System.out.print(r2.getInt(5)+" ");
			}
			
			st.execute("delete from student where id = 210");
			System.out.println("\nTable after deleting student with id 210");
			ResultSet r3 = st.executeQuery("select * from student" );
			while (r3.next())
			{
				System.out.println();
				System.out.print(r3.getInt(1)+ " ");
				System.out.print(r3.getString(2)+ " ");
				System.out.print(r3.getInt(5)+ " ");
			}
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
