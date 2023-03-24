package com.admin.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.admin.ExceptionHandle.ResourceNotFoundException;
import com.admin.Model.Teachers;
import com.admin.Repository.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService{
	private TeacherRepository teacherRepository;

	public TeacherServiceImpl(TeacherRepository teacherRepository) {
		super();
		this.teacherRepository = teacherRepository;
	}
	
	@Override
	public Teachers addTeacher(Teachers teacher) {
		return teacherRepository.save(teacher);
	}

	@Override
	public List<Teachers>getAllTeachers() {

		return teacherRepository.findAll() ;
	}
//	@Override
//	public Teachers getTeacherById(Long teacher_id) {
//		Optional<Teachers> teacher = teacherRepository.findById(teacher_id);
//		if(teacher.isPresent()) {
//			return teacher.get();
//		}else {
//			throw new ResourceNotFoundException("Teachers", "Id", teacher_id);
//		}
//	}
	@Override
	public Teachers updateTeacher(Teachers teacher, String teacher_email) {
		Teachers existingTeacher = teacherRepository.findById(teacher_email).orElseThrow(
				() -> new ResourceNotFoundException("Student", "Id", teacher_email));
		
		existingTeacher.setTeachername(teacher.getTeachername());
		existingTeacher.setTeacher_email(teacher.getTeacher_email());
		existingTeacher.setGender(teacher.getGender());
		existingTeacher.setTeacher_class(teacher.getTeacher_class());
		existingTeacher.setSubject(teacher.getSubject());
		existingTeacher.setPhonenumber(teacher.getPhonenumber());
		teacherRepository.save(existingTeacher);
		return existingTeacher;
	}
	@Override
	public void deleteTeacher(String teacher_email) {
		teacherRepository.findById(teacher_email).orElseThrow(() -> 
		new ResourceNotFoundException("Teacher", "Id", teacher_email));
		teacherRepository.deleteById(teacher_email);

	}

}
