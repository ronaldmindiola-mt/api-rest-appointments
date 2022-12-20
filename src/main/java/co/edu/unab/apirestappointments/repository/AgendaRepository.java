package co.edu.unab.apirestappointments.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import co.edu.unab.apirestappointments.models.Agenda;
public interface AgendaRepository extends MongoRepository<Agenda, String> {

}