package co.edu.unab.apirestappointments.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unab.apirestappointments.models.Physician;
import co.edu.unab.apirestappointments.services.PhysicianService;

@RestController
@RequestMapping("/api/medicos")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })

public class PhysicianController {
    
    @Autowired
    PhysicianService physicianService;

    @GetMapping()
    public List<Physician> getAllPhysicians(){
        return physicianService.getAllPhysicians();
    }

    @PostMapping()
    public Physician savePhysician(@RequestBody Physician physician){
        return physicianService.savePhysician(physician);
    }
}
