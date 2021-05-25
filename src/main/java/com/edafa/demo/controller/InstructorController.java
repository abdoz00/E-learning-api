package com.edafa.demo.controller;

import com.edafa.demo.entity.Instructor;
import com.edafa.demo.entity.Student;
import com.edafa.demo.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InstructorController {

    @Autowired
    InstructorService instructorService;


    @GetMapping("/instructors")
    public List getInstructors(){
        return instructorService.getAll() ;
    }

    @PostMapping("/instructor")
    public String addNewInstructor(@RequestBody Instructor instructor){
        return instructorService.registerNewInstructor(instructor);
    }
}
