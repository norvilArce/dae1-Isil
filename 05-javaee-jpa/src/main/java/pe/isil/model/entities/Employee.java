package pe.isil.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table (name = "tbl_empleados")
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "dni", length = 8)
    private String dni;

    @Column(name = "nombres", length = 50)
    private String name;

    @Column(name = "ape_paterno", length = 50)
    private String lastNameFather;

    @Column(name = "ape_materno", length = 50)
    private String lastNameMother;

    @Column(name = "fecha_nacimiento")
    LocalDate birthDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "compania_id")
    private Company company;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "direccion_id")
    private Address address;

    @OneToMany(mappedBy = "employee")
    private List<EmployeeProject> employeeProjectList;

    public Employee(Integer id, String dni, String name, String lastNameFather, String lastNameMother, LocalDate birthDate, Company company, Address address) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.lastNameFather = lastNameFather;
        this.lastNameMother = lastNameMother;
        this.birthDate = birthDate;
        this.company = company;
        this.address = address;
    }
}
