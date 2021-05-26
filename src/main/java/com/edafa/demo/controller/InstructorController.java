package com.edafa.demo.controller;

import com.edafa.demo.entity.Instructor;
import com.edafa.demo.service.InstructorService;
import com.edafa.demo.user.UserRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class InstructorController {

    @Autowired
    InstructorService instructorService;


    @GetMapping("/instructors")
    public List getInstructors(){
        if(UserRequestHandler.requestFlag)
        {return instructorService.getAll() ;}
        else return Arrays.asList("You exceeded your request limit");

    }

    @PostMapping("/instructor")
    public String addNewInstructor(@RequestBody Instructor instructor){
        if(UserRequestHandler.requestFlag)
        {return instructorService.registerNewInstructor(instructor);}
        else return ("You exceeded your request limit");
    }
}
