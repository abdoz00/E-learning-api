package com.edafa.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Student {

   @Id
   @Column
   private int id;
   @Column
   private String name;
   @Column
   private Date date_of_birth;
   @Column
   private String nationality;
   @Column
   private String email;

   @ManyToMany(mappedBy = "students")
   @JsonIgnoreProperties({"instructor","students"})
   private List<Course> courses;

   public List<Course> getCourses() {
      return courses;
   }

   public void setCourses(List<Course> courses) {
      this.courses = courses;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Date getDate_of_birth() {
      return date_of_birth;
   }

   public void setDate_of_birth(Date date_of_birth) {
      this.date_of_birth = date_of_birth;
   }

   public String getNationality() {
      return nationality;
   }

   public void setNationality(String nationality) {
      this.nationality = nationality;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

}
