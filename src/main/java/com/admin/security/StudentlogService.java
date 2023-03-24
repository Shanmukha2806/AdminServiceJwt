package com.admin.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.admin.Model.Students;
import com.admin.Repository.StudentRepository;

@Service
public class StudentlogService implements UserDetailsService{
	@Autowired
    StudentRepository studentRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        Students students = studentRepository.findById(username).get();
        if(students == null) {
            return null;
        }        
        return new Studentlog(students);
    }
    
}