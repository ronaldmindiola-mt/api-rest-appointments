package co.edu.unab.apirestappointments.models;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("patients")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Patient {

    @Id
    public String id;
    public Integer dni;
    public String name;
    public String lastName;
    public LocalDate dayOfBirth;
    public Integer height; // Centimetros
    public Integer weight; // Kilogramos
    // Grupo Sanguineo
    public List<String> alergies; // Lista de Alergias ["Ibuprofeno","Acetaminofen"]
    public Object address; // {city: "Riohacha", state: "La Guajira"}

}