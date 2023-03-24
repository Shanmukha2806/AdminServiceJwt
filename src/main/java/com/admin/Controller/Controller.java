package com.admin.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.Model.Students;
import com.admin.Model.Teachers;
import com.admin.Service.StudentService;
import com.admin.Service.TeacherService;
import com.admin.jwt.JwtUtils;


@CrossOrigin(origins ="http://localhost:3000/" )
@RestController
@RequestMapping("/api")
public class Controller {
	@Autowired
	private StudentService studentService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	AuthenticationManager authmanage;

	@Autowired
	JwtUtils jwtUtils;

	
	public Controller(StudentService studentService, TeacherService teacherService) {
		super();
		this.studentService = studentService;
		this.teacherService = teacherService;
	}

	@PostMapping("/student")
	public ResponseEntity<Students> addStudent(@RequestBody Students students){
		String pass = students.getStudent_password();
		students.setStudent_password(new BCryptPasswordEncoder().encode(pass));
		return new ResponseEntity<Students>(studentService.addStudent(students), HttpStatus.CREATED);
		
	}
	@GetMapping("/students")
	public List<Students> getAllStudents(){
		return studentService.getAllStudents();
		
	}
	@PutMapping("/student/{student_email}")
	public ResponseEntity<Students> updateStudent(@PathVariable("student_email") String student_email, @RequestBody Students students){

		return new ResponseEntity<Students>(studentService.updateStudent(students,student_email), HttpStatus.OK);
		
	}

	@DeleteMapping("/student/{student_email}")
	public ResponseEntity<String> deleteStudent(@PathVariable("student_email") String student_email){
		studentService.deleteStudent(student_email);;
		return new ResponseEntity<String>("Student deleted successfully", HttpStatus.OK);
	}
	
	@PostMapping("/teacher")
	public ResponseEntity<Teachers> addTeacher(@RequestBody Teachers teachers){
		return new ResponseEntity<Teachers>(teacherService.addTeacher(teachers), HttpStatus.CREATED);
	}
	@GetMapping("/teachers")
	public List<Teachers> getAllTeachers(){
		return teacherService.getAllTeachers();
		
	}
	
	@PutMapping("/teacher/{teacher_email}")
	public ResponseEntity<Teachers> updateTeacher(@PathVariable("teacher_email") String teacher_email, @RequestBody Teachers teachers){

		return new ResponseEntity<Teachers>(teacherService.updateTeacher(teachers,teacher_email), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/teacher/{teacher_email}")
	public ResponseEntity<String> deleteTeacher(@PathVariable("teacher_email") String teacher_email){
		teacherService.deleteTeacher(teacher_email);;
		return new ResponseEntity<String>("Teacher deleted successfully", HttpStatus.OK);
	}
	@PostMapping("/authenticate")
	public String authDoctor(@RequestBody Students students){
		try {
			@SuppressWarnings("unused")

			Authentication authtoken=  authmanage.authenticate(
					new UsernamePasswordAuthenticationToken(students.getStudent_email(), students.getStudent_password()));
			String token = jwtUtils.generateToken(students.getStudent_email().toString());
			return token;

		} catch (Exception e) {
			// TODO: handle exception
			return "Login Failed";
		}
	}
}
