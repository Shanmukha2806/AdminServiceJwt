package com.admin.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.admin.Model.Students;


@SuppressWarnings("serial")
public class Studentlog implements UserDetails{
Students students = new Students();
    
    public Studentlog(Students students){
        this.students = students;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return Collections.singleton(new SimpleGrantedAuthority("STUDENTS"));
    }

    @Override
    public String getPassword() {
        return students.getStudent_password();
    }   

    @Override
    public String getUsername() {
        return students.getStudent_email();
    }
    
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}