package pe.isil.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tbl_direccion")
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", length = 100)
    private String name;

    @Column (name = "ciudad", length = 50)
    private String city;

    @Column(name = "pais", length = 50)
    private String country;

    @OneToOne(mappedBy = "address")
    private Employee employee;

}
