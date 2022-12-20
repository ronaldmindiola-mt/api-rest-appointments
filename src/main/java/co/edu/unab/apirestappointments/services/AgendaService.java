package co.edu.unab.apirestappointments.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unab.apirestappointments.models.Agenda;
import co.edu.unab.apirestappointments.models.Physician;
import co.edu.unab.apirestappointments.repository.AgendaRepository;
import co.edu.unab.apirestappointments.repository.PhysicianRepository;

@Service
public class AgendaService {

    @Autowired
    AgendaRepository agendaRepository;
    @Autowired
    PhysicianRepository physicianRepository;

    public List<Agenda> getListAgendas(){
        return agendaRepository.findAll();
    }

    public Optional<Agenda> getAgendaById(String id){
        Optional<Agenda> agenda = agendaRepository.findById(id);
        Optional<Physician> physician = physicianRepository.findById(agenda.get().getIdPhysician());
        agenda.get().setNamePhysician(physician.get().getName());
        agenda.get().setSpecialty(physician.get().getSpecialty());
        return agenda;
    }

    public Agenda saveAgenda(Agenda agenda){
        return agendaRepository.save(agenda);
    }

    public String deleteAgendaById(String id){
        
        if(agendaRepository.existsById(id)){
            agendaRepository.deleteById(id);
            return "La Agenda fué eliminada con exito!";
        }else {
            return "La Agenda NO ha sido eliminada!";
        }
    }
}
