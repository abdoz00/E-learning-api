package com.edafa.demo.controller;

import com.edafa.demo.dao.InstructorRepo;
import com.edafa.demo.entity.Student;
import com.edafa.demo.service.CourseService;
import com.edafa.demo.service.InstructorService;
import com.edafa.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public List getAllStudents(){
        return studentService.getAll();
    }

    @GetMapping("/student")
    public List getByNationality(@RequestParam String nat){
        return studentService.getByNationality(nat);
    }

    @PostMapping("/student")
    public String addNewStudent(@RequestBody Student st){
        return studentService.registerNewStudent(st);
    }

    @PutMapping("/student")
    public String updateStudent(@RequestParam int id,@RequestBody Student st){
        return studentService.updateStudent(id,st);
    }

    @DeleteMapping("/student")
    public String deleteStudent(@RequestParam int id){
        return studentService.deleteStudent(id);
    }

}
