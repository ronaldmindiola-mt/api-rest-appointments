package co.edu.unab.apirestappointments.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import co.edu.unab.apirestappointments.models.Agenda;

@Repository
public interface AgendaRepository extends MongoRepository<Agenda, String> {
    
}
