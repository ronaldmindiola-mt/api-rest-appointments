package co.edu.unab.apirestappointments.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("physicians")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Physician {
    
    @Id
    private String id;
    public Integer dni;
    public String name;
    public String lastName;
    public String specialty;

}
