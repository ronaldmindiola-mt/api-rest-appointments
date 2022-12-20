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
    public String name;
    public String lastName;
    public long dni;
    public LocalDate dayOfBirth;
    public List<String> alergies;
    public Object address;
    
}