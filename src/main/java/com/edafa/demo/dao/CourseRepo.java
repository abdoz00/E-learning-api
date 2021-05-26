package com.edafa.demo.dao;

import com.edafa.demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepo extends JpaRepository<Course,Long> {
}
