package pe.isil.model.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@EqualsAndHashCode //unica
@Data
@Embeddable
public class EmployeeProjectKey implements Serializable {

    @Column(name = "empleado_id")
    private Integer employeeId;

    @Column(name = "proyecto_id")
    private Integer projectId;

}
