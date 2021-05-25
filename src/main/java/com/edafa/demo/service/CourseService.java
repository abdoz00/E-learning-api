package com.edafa.demo.service;

import com.edafa.demo.dao.CourseRepo;
import com.edafa.demo.entity.Course;
import com.edafa.demo.entity.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepo repo;

    public List getAllCourses(){
        return repo.findAll();
    }

    public String registerNewCourse(Course course) {
        repo.save(course);
        return "Added Successfully";
    }
}
