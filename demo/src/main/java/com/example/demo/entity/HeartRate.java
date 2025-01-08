package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "heart_rate_data")
public class HeartRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;  // Relates to the Patient entity

    @Column(nullable = false)
    private String heartRateData;  // Stores heart rate data (e.g., as a JSON string or CSV)

    @Column(nullable = false)
    private String timestamp;  // Stores timestamp of heart rate data

    // Default constructor
    public HeartRate() {}

    // Parameterized constructor
    public HeartRate(Long id, Patient patient, String heartRateData, String timestamp) {
        this.id = id;
        this.patient = patient;
        this.heartRateData = heartRateData;
        this.timestamp = timestamp;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getHeartRateData() {
        return heartRateData;
    }

    public void setHeartRateData(String heartRateData) {
        this.heartRateData = heartRateData;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}