package com.admin.Model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "student")
public class Students {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long student_id;
	
	@Column(name = "student_firstname")
	private String student_firstname;
	
	@Column(name = "student_lastname")
	private String student_lastname;
	
	@Id
	@Column(name = "student_email")
	private String student_email;
	
	@Column(name = "student_password")
	private String student_password;
	
	@Column(name = "dob")
	private String dob;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "student_class")
	private int student_class;
	
	@Column(name = "fathername")
	private String fathername;
	
	@Column(name = "mothername")
	private String mothername;
	
	@Column(name = "teacher_email")
	private String teacher_email;

	@Column(name = "fees")
	private Boolean fees;

	public Students() {
		super();
	}

	public Students(long student_id, String student_firstname, String student_lastname, String student_email,
			String student_password, String dob, String gender, int student_class, String fathername, String mothername,
			String teacher_email, Boolean fees) {
		super();
		this.student_id = student_id;
		this.student_firstname = student_firstname;
		this.student_lastname = student_lastname;
		this.student_email = student_email;
		this.student_password = student_password;
		this.dob = dob;
		this.gender = gender;
		this.student_class = student_class;
		this.fathername = fathername;
		this.mothername = mothername;
		this.teacher_email = teacher_email;
		this.fees = fees;
	}

	public long getStudent_id() {
		return student_id;
	}

	public void setStudent_id(long student_id) {
		this.student_id = student_id;
	}

	public String getStudent_firstname() {
		return student_firstname;
	}

	public void setStudent_firstname(String student_firstname) {
		this.student_firstname = student_firstname;
	}

	public String getStudent_lastname() {
		return student_lastname;
	}

	public void setStudent_lastname(String student_lastname) {
		this.student_lastname = student_lastname;
	}

	public String getStudent_email() {
		return student_email;
	}

	public void setStudent_email(String student_email) {
		this.student_email = student_email;
	}

	public String getStudent_password() {
		return student_password;
	}

	public void setStudent_password(String student_password) {
		this.student_password = student_password;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getStudent_class() {
		return student_class;
	}

	public void setStudent_class(int student_class) {
		this.student_class = student_class;
	}

	public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public String getMothername() {
		return mothername;
	}

	public void setMothername(String mothername) {
		this.mothername = mothername;
	}

	public String getTeacher_email() {
		return teacher_email;
	}

	public void setTeacher_email(String teacher_email) {
		this.teacher_email = teacher_email;
	}

	public Boolean getFees() {
		return fees;
	}

	public void setFees(Boolean fees) {
		this.fees = fees;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dob, fathername, fees, gender, mothername, student_class, student_email, student_firstname,
				student_id, student_lastname, student_password, teacher_email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Students other = (Students) obj;
		return Objects.equals(dob, other.dob) && Objects.equals(fathername, other.fathername)
				&& Objects.equals(fees, other.fees) && Objects.equals(gender, other.gender)
				&& Objects.equals(mothername, other.mothername) && student_class == other.student_class
				&& Objects.equals(student_email, other.student_email)
				&& Objects.equals(student_firstname, other.student_firstname) && student_id == other.student_id
				&& Objects.equals(student_lastname, other.student_lastname)
				&& Objects.equals(student_password, other.student_password)
				&& Objects.equals(teacher_email, other.teacher_email);
	}

}