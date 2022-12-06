package co.edu.unab.apirestappointments.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.unab.apirestappointments.models.Agenda;
import co.edu.unab.apirestappointments.models.Physician;
import co.edu.unab.apirestappointments.repository.AgendaRepository;
import co.edu.unab.apirestappointments.repository.PhysicianRepository;

public class AgendaService {
    
    @Autowired
    AgendaRepository agendaRepository;

    @Autowired
    PhysicianRepository physicianRepository;

    public Optional <Agenda> getAgendaById(String id){
        Optional<Agenda> agenda = agendaRepository.findById(id);
        Optional<Physician> physician = physicianRepository.findById(agenda.get().getIdPhysician());
        agenda.get().setNamePhysician(physician.get().getName());
        agenda.get().setSpecialty(physician.get().getSpecialty());
        return agenda;
    }

    public Agenda saveAgenda(Agenda agenda){
        return agendaRepository.save(agenda);
    }
}
