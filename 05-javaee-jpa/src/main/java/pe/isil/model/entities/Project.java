package pe.isil.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tbl_proyecto")
@Entity
public class Project {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(name = "nombre", length = 50)
    private String name;

    @Column(name = "presupuesto")
    private Double budget;

    @Column(name = "duracion")
    private Integer duration;

    @Column(name = "activo")
    private Boolean active;

    @OneToMany(mappedBy = "project")
    private List<EmployeeProject> employeeProjectList;

}
