package co.edu.unab.apirestappointments.services;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unab.apirestappointments.models.Physician;
import co.edu.unab.apirestappointments.repository.PhysicianRepository;

@Service
public class PhysicianService {
    
    @Autowired
    PhysicianRepository physicianRepository;

    public List<Physician> getAllPhysicians(){
        List<Physician> physicians = physicianRepository.findAll();
        physicians.sort(Comparator.comparing(Physician::getSpecialty));
        return physicians;
    }

    public Physician savePhysician(Physician physician){
        return physicianRepository.save(physician);
    }

}
