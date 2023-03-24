package com.admin.Service;

import java.util.List;

import com.admin.Model.Teachers;

public interface TeacherService {
	Teachers addTeacher(Teachers teacher);
	List<Teachers> getAllTeachers();
//	Teachers getTeacherById(Long teacher_id);
	Teachers updateTeacher(Teachers teacher,String teacher_email);
	void deleteTeacher(String teacher_email);
}
