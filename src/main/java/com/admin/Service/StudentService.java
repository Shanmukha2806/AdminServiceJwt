package com.admin.Service;
import java.util.List;

import com.admin.Model.Students;
public interface StudentService {
	Students addStudent(Students student);
	List<Students> getAllStudents();
	Students updateStudent(Students student,String student_email);
	void deleteStudent(String student_email);
}
