package com.example.demo.controller;

import com.example.demo.entity.HeartRate;
import com.example.demo.service.HeartRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/heart-rate")
public class HeartRateController {

    @Autowired
    private HeartRateService heartRateService;

    @PostMapping("/add")
    public ResponseEntity<HeartRate> addHeartRate(@RequestBody HeartRate heartRate) {
        HeartRate savedHeartRate = heartRateService.addHeartRate(heartRate);
        return ResponseEntity.ok(savedHeartRate);
    }

    @GetMapping("/details")
    public ResponseEntity<List<HeartRate>> getHeartRateDetails(@RequestParam Long patientId) {
        List<HeartRate> heartRates = heartRateService.getHeartRateByPatientId(patientId);
        if (!heartRates.isEmpty()) {
            return ResponseEntity.ok(heartRates);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }
}