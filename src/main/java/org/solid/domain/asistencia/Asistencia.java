package org.solid.domain.asistencia;

import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class Asistencia {
  private LocalTime horaEntrada;
  private LocalTime horaSalida;
}
