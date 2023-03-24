package com.admin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.admin.Model.Students;
public interface StudentRepository extends JpaRepository<Students, String>{

}
