package com.example.studentfinalproject.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "student_profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column
    @NotNull
    private String name;

//    @OneToOne(mappedBy = "student")
//    private Student student;

    public Profile(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Profile() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}