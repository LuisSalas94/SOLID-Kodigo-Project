package org.solid.domain.designpatterns.decorator;

import org.solid.domain.asistencia.Asistencia;
import org.solid.domain.asistencia.Ausencia;

import java.time.LocalDate;

// Component Interface
public interface AsistenciaLaboralComponent {
    void registrarAusencia(LocalDate fecha, Ausencia ausencia);

    void registrarAsistencia(LocalDate fecha, Asistencia asistencia);

    void asignarVacaciones(LocalDate fechaInicio, LocalDate fechaFinal);

    void eliminarAsistencia(LocalDate fecha);

    void eliminarAusencia(LocalDate fecha);
}
