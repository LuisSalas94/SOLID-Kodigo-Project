package org.solid.domain.horario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public abstract class Horario {
  private String nombre;
  private String descripcion;
}
