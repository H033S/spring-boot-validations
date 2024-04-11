package com.expeditors.validations.medicalfacility.controller;


import com.expeditors.validations.medicalfacility.dto.PatientRequest;
import com.expeditors.validations.medicalfacility.dto.PatientResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/patient")
public class PatientController {


    @GetMapping
    public String getPatient(){
        return "Hello World";
    }

    @PostMapping
    public PatientResponse addPatient(
            @Valid @RequestBody PatientRequest patientRequest){

        var patient = patientRequest.toEntity();
        return PatientResponse.fromEntity(patient);
    }

}
