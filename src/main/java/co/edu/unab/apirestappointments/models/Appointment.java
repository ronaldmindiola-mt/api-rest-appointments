package co.edu.unab.apirestappointments.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Appointment {
    
    private String idPatient;
    private String hour;

}
