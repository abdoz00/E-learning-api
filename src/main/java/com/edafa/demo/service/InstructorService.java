package com.edafa.demo.service;

import com.edafa.demo.dao.InstructorRepo;
import com.edafa.demo.entity.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepo repo;

    public String registerNewInstructor(Instructor instructor) {
        if(repo.getByEmail(instructor.getEmail()).isPresent())
        {return "Already Exist";}
        repo.save(instructor);
        return "Added Successfully";
    }

    public List getAll(){
        return repo.findAll();
    }

}
