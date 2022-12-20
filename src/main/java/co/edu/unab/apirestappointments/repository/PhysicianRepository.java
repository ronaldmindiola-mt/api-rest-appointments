package co.edu.unab.apirestappointments.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import co.edu.unab.apirestappointments.models.Physician;
public interface PhysicianRepository extends MongoRepository<Physician, String> {
    
}