package com.edafa.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class User {
    @Id
    @Column
    @Setter
    @Getter
    private long id;

    @Column(name = "user_name")
    @Setter
    @Getter
    private String name;
    @Column
    @Setter
    private String password;
    @Column
    @Setter
    @Getter
    private int max_requests;
    @Column
    @Setter
    @Getter
    private int current_requests;


}
