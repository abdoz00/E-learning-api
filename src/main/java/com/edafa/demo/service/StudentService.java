package com.edafa.demo.service;

import com.edafa.demo.dao.StudentRepo;
import com.edafa.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepo repo;

    public List getAll(){
        return repo.findAll();
    }

    public List getByNationality(String nat){
        return repo.findByNationality(nat);
    }

    public String registerNewStudent(Student st) {
        if(repo.getByEmail(st.getEmail()).isPresent())
        {return "Already Exist";}
        repo.save(st);
        return "Added Successfully";
    }

    public String deleteStudent(int id){
        Student st=repo.getById(id);
        if (Objects.isNull(st)){return "ID is Not Found";}
        repo.delete(st);
        return "Success";
    }

    @Transactional
    public String updateStudent(int id,Student st) {
        Student oldSt=repo.getById(id);
        if (Objects.isNull(st.getName()) || Objects.isNull(st.getEmail())){
            return "Name or Email Not Found";
        }
        oldSt.setName(st.getName());
        oldSt.setEmail(st.getEmail());
        oldSt.setNationality(st.getNationality());
        oldSt.setDate_of_birth(st.getDate_of_birth());
        return "success";
    }
}
