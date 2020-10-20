package pe.isil.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;

}
