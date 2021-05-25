package com.edafa.demo.controller;

import com.edafa.demo.entity.Course;
import com.edafa.demo.entity.Instructor;
import com.edafa.demo.service.CourseService;
import com.edafa.demo.user.ActiveUserStore;
import com.edafa.demo.user.UserRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    CourseService courseService;



    @GetMapping("/courses")
    public List getAllCourses(){
        return courseService.getAllCourses();
    }

    @PostMapping("/course")
    public String addNewInstructor(@RequestBody Course course){
        return courseService.registerNewCourse(course);
    }


}
