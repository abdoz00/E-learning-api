package com.edafa.demo.controller;

import com.edafa.demo.entity.Course;
import com.edafa.demo.service.CourseService;
import com.edafa.demo.user.UserRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    CourseService courseService;



    @GetMapping("/courses")
    public List getAllCourses(){
        if(UserRequestHandler.requestFlag)
        {return courseService.getAllCourses();}
        else return Arrays.asList("You exceeded your request limit");
    }

    @PostMapping("/course")
    public String addNewInstructor(@RequestBody Course course){

        if(UserRequestHandler.requestFlag)
        {return courseService.registerNewCourse(course);}
        else return ("You exceeded your request limit");
    }


}
