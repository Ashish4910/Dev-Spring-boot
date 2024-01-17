package com.luv2code.cruddemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // its used to declare the class as entity class and used to bind class to
		// database
@Table(name = "student") // table name
public class Student {

	// define fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // this tell the code that id is auto_generated

	@Column(name = "id") // this is column name in table
	private int id; // variable name

	@Column(name = "first_name") // column name in the table
	private String firstName; // variable name

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	// define constructor

	public Student() {
		// no argument
	}

	// define getters / setters

	public int getId() { // getter
		return id;
	}

	public void setId(int id) { // setter
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Student(String firstName, String lastName, String email) { // argument constructor
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	// define toStrings methods
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
}
