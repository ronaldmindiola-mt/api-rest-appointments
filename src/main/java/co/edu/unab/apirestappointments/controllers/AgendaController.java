package co.edu.unab.apirestappointments.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unab.apirestappointments.models.Agenda;
import co.edu.unab.apirestappointments.services.AgendaService;

@RestController
@RequestMapping("/api/agendas")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class AgendaController {
    
    @Autowired
    AgendaService agendaService;

    @GetMapping()
    public List<Agenda> findAgendas(){
        return agendaService.getListAgendas();
    }

    @GetMapping("/{id}")
    public Optional<Agenda> findAgendaById(@PathVariable("id") String id){
        return agendaService.getAgendaById(id);
    }

    @PostMapping()
    public Agenda saveAgenda(@RequestBody Agenda agenda){
        return agendaService.saveAgenda(agenda);
    }

    @DeleteMapping("/{id}")
    public String deleteAgenda(@PathVariable("id") String id){
        return agendaService.deleteAgendaById(id);
    }
}
