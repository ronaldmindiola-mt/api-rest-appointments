package co.edu.unab.apirestappointments.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unab.apirestappointments.models.Patient;
import co.edu.unab.apirestappointments.repository.PatientRepository;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    @GetMapping
    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    @PostMapping()
    public Patient savePatient(@RequestBody Patient patient){
        return patientRepository.save(patient);
    }
}
