package com.admin.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.admin.ExceptionHandle.ResourceNotFoundException;
import com.admin.Model.Students;
import com.admin.Repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	private StudentRepository studentRepository;

	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public Students addStudent(Students student) {
		return studentRepository.save(student);
	}
	@Override
	public List<Students> getAllStudents() {

		return studentRepository.findAll() ;
		
	}

//	@Override
//	public Students getStudentById(Long student_id) {
//		Optional<Students> student = studentRepository.findById(student_id);
//		if(student.isPresent()) {
//			return student.get();
//		}else {
//			throw new ResourceNotFoundException("Student", "Id", student_id);
//		}
//	}

	@Override
	public Students updateStudent(Students student, String student_email) {
		Students existingStudent = studentRepository.findById(student_email).orElseThrow(
				() -> new ResourceNotFoundException("Student", "Id", student_email));

				existingStudent.setStudent_firstname(student.getStudent_firstname());
				existingStudent.setStudent_lastname(student.getStudent_lastname());
//				existingStudent.setStudent_email(student.getStudent_email());
				existingStudent.setDob(student.getDob());
				existingStudent.setGender(student.getGender());
				existingStudent.setStudent_class(student.getStudent_class());
				existingStudent.setFathername(student.getFathername());
				existingStudent.setMothername(student.getMothername());
				existingStudent.setTeacher_email(student.getTeacher_email());
//				existingStudent.setFees(student.getFees());
				studentRepository.save(existingStudent);
				return existingStudent;
	}

	@Override
	public void deleteStudent(String student_email) {
		studentRepository.findById(student_email).orElseThrow(() -> 
		new ResourceNotFoundException("Employee", "Id", student_email));
		studentRepository.deleteById(student_email);

	}

}
