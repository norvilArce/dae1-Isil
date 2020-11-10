package pe.isil.model.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tbl_employee_project")
@Entity
public class EmployeeProject {

    @EmbeddedId //clave compuesta
    private EmployeeProjectKey id;

    @ManyToOne
    @MapsId("empleado_id")
    @JoinColumn(name = "empleado_id")
    private Employee employee;

    @ManyToOne()
    @MapsId("proyecto_id")
    @JoinColumn(name = "proyecto_id")
    private Project project;

    @Column(name = "fecha_creacion")
    private LocalDate createdDate;
}
