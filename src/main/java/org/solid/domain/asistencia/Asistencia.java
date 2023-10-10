package org.solid.domain.asistencia;

import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Asistencia {
  private LocalTime horaEntrada;
  private LocalTime horaSalida;
}
