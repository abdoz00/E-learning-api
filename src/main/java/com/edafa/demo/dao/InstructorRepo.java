package com.edafa.demo.dao;

import com.edafa.demo.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstructorRepo extends JpaRepository<Instructor,Integer> {
    Optional<String> getByEmail(String email);
}
