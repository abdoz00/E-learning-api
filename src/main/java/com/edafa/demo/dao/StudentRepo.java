package com.edafa.demo.dao;

import com.edafa.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student,Long> {

    List findByNationality(String nat);
    Student getById(int id);
    Optional<Student> getByEmail(String email);

}
