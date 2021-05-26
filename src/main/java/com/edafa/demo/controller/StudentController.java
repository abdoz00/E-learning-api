package com.edafa.demo.controller;

import com.edafa.demo.entity.Student;
import com.edafa.demo.service.StudentService;
import com.edafa.demo.user.UserRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public List getAllStudents(){
        if(UserRequestHandler.requestFlag)
        {
            return studentService.getAll();
        }
        return Arrays.asList("You exceeded your request limit");
    }

    @GetMapping("/student")
    public List getByNationality(@RequestParam String nat){
        if(UserRequestHandler.requestFlag)
        {
            return studentService.getByNationality(nat);
        }
        return Arrays.asList("You exceeded your request limit");

    }

    @PostMapping("/student")
    public String addNewStudent(@RequestBody Student st){
        if(UserRequestHandler.requestFlag)
        {
            return studentService.registerNewStudent(st);
        }
        return ("You exceeded your request limit");
    }

    @PutMapping("/student")
    public String updateStudent(@RequestParam int id,@RequestBody Student st){
        if(UserRequestHandler.requestFlag)
        {
            return studentService.updateStudent(id,st);
        }
        return ("You exceeded your request limit");
    }

    @DeleteMapping("/student")
    public String deleteStudent(@RequestParam int id){
        if(UserRequestHandler.requestFlag)
        {
            return studentService.deleteStudent(id);
        }
        return ("You exceeded your request limit");

    }

}
