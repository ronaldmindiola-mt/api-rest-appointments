package co.edu.unab.apirestappointments.services;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unab.apirestappointments.models.Patient;
import co.edu.unab.apirestappointments.repository.PatientRepository;

@Service
public class PatientService {
    
    @Autowired
    PatientRepository patientRepository;

    // Lista de Pacientes ordenados por apellido.
    public List<Patient> getListPatientsOrderByLastName(){
        List<Patient> listPatients = patientRepository.findAll();
        listPatients.sort(Comparator.comparing(Patient::getLastName));
        return listPatients;
    }

    // Busca un paciente por su id.
    public Optional<Patient> getPatientById(String id){
        return patientRepository.findById(id);
    }

    // Busca un paciente por su apellido
    public List<Patient> getPatientByLastName(String lastName){
        return patientRepository.findByLastName(lastName);
    }

    // Guarda un paciente
    public String savePatient(Patient patient){
        
        patient.setName(patient.getName().toLowerCase());
        patient.setLastName(patient.getLastName().toLowerCase());
        patient.setDayOfBirth(patient.getDayOfBirth());
        patient.setAlergies(patient.getAlergies());
        patient.setAddress(patient.getAddress());

        boolean state = patient.getId() == null || !patientRepository.existsById(patient.getId());
        patientRepository.save(patient);
        if(state){
            return "El Paciente se guardó correctamente.";
        }else {
            return "Error al guardar Paciente";
        }

    }

    // Elimina un Paciente por su Id.
    public String deletePatient(String id){

        String fullName = "";

        if(patientRepository.existsById(id)){
            Optional<Patient> patient = patientRepository.findById(id);
            patientRepository.deleteById(id);
            fullName = patient.get().getName() + " " + patient.get().getLastName();
            return "El paciente " + fullName + " ha sido eliminado con exito!";
        }else {
            return "El paciente " + fullName + " NO ha sido Eliminado!";
        }
    }

    // Obtener una lista de Pacientes de una ciudad.
    public List<Patient> getListPatientsByCity(String city){
        return patientRepository.findByCity(city);
    }

    // Obtener una lista de Pacientes 
    public List<Patient> getListPatientsByDateMinor(LocalDate date){
        return patientRepository.findByMinorDate(date);
    }

    public boolean existsPatientByID(long dni) {
        return patientRepository.existsByDni(dni);
    }

    public Optional<Patient> patientByDni(long dni){
        return patientRepository.findByDni(dni);
    }




}