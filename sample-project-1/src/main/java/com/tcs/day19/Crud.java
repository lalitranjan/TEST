package com.tcs.day19;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class Crud {
	private JdbcTemplate jdbc;
	
	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc=jdbc;			
	}
	
	public int createTable() {
		return jdbc.update("create table student(id int NOT NULL,FirstName varchar(50) NOT NULL,LastName varchar(50),address varchar(100) NOT NULL,contactNumber long NOT NULL,Primary Key(id))");
	}
	
	public int destroyTable() {
		return jdbc.update("drop table if exists Student ");
	}
	
	public List<Student> printTable(){
		String sql = "select*from student ";
		List<Student> data = jdbc.query(sql, new StudentRowMapper());
		return data;
	}
	
	public int insertStudent(Student s) {
		String query="insert into student values('" + s.getId() +"','" + s.getFirstName() + "','" + s.getLastName()
		+ "','" + s.getAddress() + "','" + s.getContactNumber() + "')";
		return jdbc.update(query);
	}
	public List<Student> getStudent(int i) {
		String sql = "select*from student where id=" + i;
		List<Student> data = jdbc.query(sql, new StudentRowMapper());
		return data;
	}
	
	public List<Student> getStudent(String name) {
		String sql = "select*from student where firstname='" + name + "'";
		List<Student> data = jdbc.query(sql, new StudentRowMapper());
		return data;
	}
	
	public List<Student> getStudent(long contact) {
		String sql = "select*from student where contactnumber=" + contact;
		List<Student> data = jdbc.query(sql, new StudentRowMapper());
		return data;
	}
	
	public int updateName(long num) {
		String query="Update student set firstname = 'sam' where contactnumber =" + num;
		return jdbc.update(query);
	}
	
	public int deleteStudent(int id) {
		String query="Delete from student where id=" + id;
		return jdbc.update(query);
	}
	
}

class StudentRowMapper implements RowMapper<Student> {

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Student s = new Student();
		s.setId(rs.getInt("id"));
		s.setFirstName(rs.getString("firstname"));
		s.setLastName(rs.getString("lastname"));
		s.setAddress(rs.getString("address"));
		s.setContactNumber(rs.getLong("contactnumber"));
		return s;
	}
	
	
}












