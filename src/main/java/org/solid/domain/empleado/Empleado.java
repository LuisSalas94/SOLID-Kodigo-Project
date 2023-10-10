package org.solid.domain.empleado;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Empleado {

  @Getter @Setter private String nombres;

  @Getter @Setter private String apellidos;

  @Getter @Setter private LocalDate fechaNacimiento;

  @Getter @Setter private String direccion;

  @Getter @Setter private String identicicacion;

  @Getter @Setter private String contacto;

  @Getter @Setter private LocalDate fechaContrato;
}
