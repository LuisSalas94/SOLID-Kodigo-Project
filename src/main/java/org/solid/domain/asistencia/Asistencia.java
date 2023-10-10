package org.solid.domain.asistencia;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@AllArgsConstructor
@Setter
@Getter
public class Asistencia {
    private LocalTime horaEntrada;
    private LocalTime horaSalida;
}