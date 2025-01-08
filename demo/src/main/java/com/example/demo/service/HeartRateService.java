package com.example.demo.service;

import com.example.demo.entity.HeartRate;
import com.example.demo.repository.HeartRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeartRateService {

    @Autowired
    private HeartRateRepository heartRateRepository;

    public HeartRate addHeartRate(HeartRate heartRate) {
        return heartRateRepository.save(heartRate);
    }

    public List<HeartRate> getHeartRateByPatientId(Long patientId) {
        return heartRateRepository.findByPatientId(patientId);
    }
}