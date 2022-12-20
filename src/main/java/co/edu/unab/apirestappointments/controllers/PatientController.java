package co.edu.unab.apirestappointments.controllers;

import java.time.LocalDate;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unab.apirestappointments.models.Patient;
import co.edu.unab.apirestappointments.services.PatientService;

@RestController
@RequestMapping("/api/pacientes")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class PatientController {

    @Autowired
    PatientService patientService;

    // Lista de pacientes
    @GetMapping()
    public List<Patient> getListPatientsOrderByLastName() {
        return patientService.getListPatientsOrderByLastName();
    }

    // Busca un Paciente por Id
    @GetMapping("/{id}")
    public Optional<Patient> findPatientById(@PathVariable("id") String id){ 
        return patientService.getPatientById(id);
    }

    // Consulta un Paciente por Parametro (lastName)
    @GetMapping("/query") //   /query?lastName=mindiola
    public List<Patient> findPatientByLastName(@RequestParam("lastName") String lastName){
        return patientService.getPatientByLastName(lastName);
    }

    @GetMapping("/existe/query")
    public Boolean existsPatientById(@RequestParam("dni") long dni){
        return patientService.existsPatientByID(dni);
    }

    @GetMapping("/fecha/query")
    public List<Patient> findPatientByDateMinorList(@RequestParam("date") String date){
        LocalDate localDate = LocalDate.parse(date);
        return patientService.getListPatientsByDateMinor(localDate);
    }

    @GetMapping("/ciudad/{ciudad}")
    public List<Patient> getListPatientsByCity(@PathVariable("city") String city){
        return patientService.getListPatientsByCity(city);
    }

    // Obtener Paciente por medio de @RequestParam
   /*  @GetMapping("/paciente")
    public Optional<Patient> findPatientById(@RequestParam(value="id") String id) {
        return patientService.getPatientById(id);
    } */

    // Obtener Paciente por medio de @PathVariable
    /* @GetMapping("/{id}")
    public Optional<Patient> findPatientById(@PathVariable("id") int id){ 
        return patientService.getPatientById(id);
    } */

    @GetMapping("/cc/{dni}")
    public Optional<Patient> findPatientByDni(@PathVariable("dni") long dni){
        return patientService.patientByDni(dni);
    }
    
    @PostMapping()
    public String savePatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

    @DeleteMapping("/{id}")
    public String deletePatientById(@PathVariable("id") String id){
        return patientService.deletePatient(id);
    }
}