package com.admin.Model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "teacher")
public class Teachers {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long teacher_id;
	
	@Column(name = "teachername")
	private String teachername;
	@Id
	@Column(name = "teacher_email")
	private String teacher_email;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "teacher_class")
	private int teacher_class;

	@Column(name = "subject")
	private String subject;

	@Column(name = "phonenumber")
	private String phonenumber;
	
	public Teachers() {
		super();
	}

	public Teachers(long teacher_id, String teachername, String teacher_email, String gender, int teacher_class,
			String subject, String phonenumber) {
		super();
		this.teacher_id = teacher_id;
		this.teachername = teachername;
		this.teacher_email = teacher_email;
		this.gender = gender;
		this.teacher_class = teacher_class;
		this.subject = subject;
		this.phonenumber = phonenumber;
	}

	public long getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(long teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getTeachername() {
		return teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	public String getTeacher_email() {
		return teacher_email;
	}

	public void setTeacher_email(String teacher_email) {
		this.teacher_email = teacher_email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getTeacher_class() {
		return teacher_class;
	}

	public void setTeacher_class(int teacher_class) {
		this.teacher_class = teacher_class;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(gender, phonenumber, subject, teacher_class, teacher_email, teacher_id, teachername);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teachers other = (Teachers) obj;
		return Objects.equals(gender, other.gender) && Objects.equals(phonenumber, other.phonenumber)
				&& Objects.equals(subject, other.subject) && teacher_class == other.teacher_class
				&& Objects.equals(teacher_email, other.teacher_email) && teacher_id == other.teacher_id
				&& Objects.equals(teachername, other.teachername);
	}	
	
}