package com.example.studentfinalproject.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private String email;


    @Column
    @NotNull
    private String phone;

    @Column
    @NotNull
    private String address;


    @Column
    @NotNull
    private int id_profile;


//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "profile_id", referencedColumnName = "id")
//    private Profile profile;

//    @OneToOne(targetEntity = Profile.class, cascade = CascadeType.ALL)
//    private Profile profile;

    public Student(Long id, String name, String email, String phone, String address, int id_profile) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.id_profile = id_profile;
    }

    public Student() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getProfile() {
        return id_profile;
    }

    public void setProfile(int id_profile) {
        this.id_profile = id_profile;
    }
}