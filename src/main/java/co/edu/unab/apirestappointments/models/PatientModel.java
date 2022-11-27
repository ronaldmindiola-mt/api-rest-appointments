package co.edu.unab.apirestappointments.models;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("patients")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PatientModel {
    public String id;
    public String name;
    public String lastName;
    public LocalDate birthDay;
    public Integer height; // Centimetros
    public Integer weight; // Kilogramos
    // Grupo Sanguineo
    public List<String> alergies; // Lista de Alergias
    public Object location; // {lat:"4345345345645", log:"45345757567"}
}
