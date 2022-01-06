package com.tcs.day19;

public class Student {
	private int id;
	private String FirstName;
	private String LastName;
	private String address;
	private long contactNumber;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long l) {      
		this.contactNumber = l;
	}
	public Student(int id, String firstName, String lastName, String address, int contactNumber) {
		super();
		this.id = id;
		FirstName = firstName;
		LastName = lastName;
		this.address = address;
		this.contactNumber = contactNumber;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", FirstName=" + FirstName + ", LastName=" + LastName + ", address=" + address
				+ ", contactNumber=" + contactNumber + "]";
	}
	

}
