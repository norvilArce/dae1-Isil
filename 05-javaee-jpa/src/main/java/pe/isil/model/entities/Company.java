package pe.isil.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table (name = "tbl_compania")
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 10)
    private String ruc;

    @Column(name = "nobre_comercial", length = 50)
    private String tradeName;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Employee> employeeList;

}