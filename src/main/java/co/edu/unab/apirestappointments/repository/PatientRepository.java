package co.edu.unab.apirestappointments.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import co.edu.unab.apirestappointments.models.Patient;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {

    List<Patient> findByLastName(String lastName);

    List<Patient> findByName(String name);

    @Query("{'address.city':?0}")
    List<Patient> findByCity(String city);

    @Query("{dayOfBirth:{$lt:?0}}")
    List<Patient>findByMinorDate(LocalDate date);

    //List<Patient>findBydayOfBirthBefore(LocalDate date);
    
}
