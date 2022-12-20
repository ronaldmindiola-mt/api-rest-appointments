package co.edu.unab.apirestappointments.models;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Document("agendas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Agenda {

    @Id
    private String id;
    private String idPhysician;
    private String namePhysician;
    private String specialty;
    private LocalDate date;
    private List<Appointment> appointments;
}