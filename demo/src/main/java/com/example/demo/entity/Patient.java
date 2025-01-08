package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private int age;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;  // Relates to the User entity

    @Column(nullable = false)
    private String heartRateData;  // To store the heart rate data as a simple string (JSON, CSV, etc.)

    // Default constructor
    public Patient() {
    }

    // Parameterized constructor
    public Patient(Long id, String name, String email, String gender, int age, User user, String heartRateData) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.age = age;
        this.user = user;
        this.heartRateData = heartRateData;
    }

    // Getters and Setters
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getHeartRateData() {
        return heartRateData;
    }

    public void setHeartRateData(String heartRateData) {
        this.heartRateData = heartRateData;
    }

    // Override toString (optional but useful for debugging)
    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", user=" + user +
                ", heartRateData='" + heartRateData + '\'' +
                '}';
    }
}