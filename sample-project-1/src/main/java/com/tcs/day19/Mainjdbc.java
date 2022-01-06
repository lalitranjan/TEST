package com.tcs.day19;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.support.JdbcUtils;

public class Mainjdbc { 

	public static void main(String[] args) throws Exception
	{
		try
		{
			ApplicationContext con = new ClassPathXmlApplicationContext("Beansjdbc.xml");
			Crud c = (Crud) con.getBean("crud");
			c.destroyTable();
			c.createTable();
			c.insertStudent(new Student(200,"ankit","kumar","NY",1234567));
			c.insertStudent(new Student(201,"ramesh","kumar","LA",1334567));
			c.insertStudent(new Student(202,"suresh","kumar","LV",1434567));
			c.insertStudent(new Student(203,"anuj","kumar","LA",1534567));
			c.insertStudent(new Student(204,"abhi","kumar","LA",1634567));
			c.insertStudent(new Student(205,"ankit","kumar","NY",1734567));
			c.insertStudent(new Student(206,"raj","kumar","LV",1834567));
			c.insertStudent(new Student(207,"rohit","kumar","NY",1934567));
			c.insertStudent(new Student(208,"rahul","kumar","NY",1244567));
			c.insertStudent(new Student(209,"rakesh","kumar","LV",1254567));
			c.insertStudent(new Student(210,"ankit","kumar","NY",1264567));
			c.insertStudent(new Student(211,"mohit","kumar","NY",1274567));
			c.insertStudent(new Student(212,"rohan","kumar","LV",1284567));
			c.insertStudent(new Student(213,"sohan","kumar","LA",1294567));
			c.insertStudent(new Student(214,"shahil","kumar","NY",1235567));
			c.insertStudent(new Student(215,"ankit","kumar","NY",1236567));
			c.insertStudent(new Student(216,"shashi","kumar","LV",1237567));
			c.insertStudent(new Student(217,"sarun","kumar","LA",1238567));
			c.insertStudent(new Student(218,"varun","kumar","LA",1239567));
			c.insertStudent(new Student(219,"pawan","kumar","LV",1234667));
			c.insertStudent(new Student(220,"ankit","kumar","NY",1234767));
			
			System.out.println("Accessing data of students with name id=211");
			List<Student> list = c.getStudent(211);
			System.out.println(list.toString());
			
			System.out.println();
			
			System.out.println("Accessing data of all students with name 'Ankit'");
			List<Student> ankitList = c.getStudent("ankit");
			for(Student i:ankitList)
			{
				System.out.println(i.toString());
			}
			
			
			System.out.println();
			
			System.out.println("Updating name of a student to 'sam' using contact number = 1239567");
			c.updateName(1239567);
			List<Student> updateName = c.getStudent(1239567);
			System.out.println(updateName.toString());
			

			System.out.println();
			
			System.out.println("Deleting a Student record with 'id'=202");
			c.deleteStudent(202);
			System.out.println();
			System.out.println("Updated table after removing student (202)");
			List<Student> listAfterDeletion = c.printTable();
			for(Student i:listAfterDeletion)
			{
				System.out.println(i.toString());
			}
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			JdbcUtils.closeConnection(null);
		}
	}	

}
