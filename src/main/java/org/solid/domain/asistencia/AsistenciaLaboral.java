package org.solid.domain.asistencia;

import java.time.LocalDate;
import java.util.HashMap;
import lombok.Getter;
import lombok.Setter;
import org.solid.domain.horario.HorarioSemanal;

public class AsistenciaLaboral {
  @Getter @Setter private HorarioSemanal horarioSemanal;
  @Getter @Setter private LocalDate fechaInicio;
  @Getter @Setter private LocalDate fechaFinal;
  @Getter private HashMap<LocalDate, Asistencia> asistencias = new HashMap<>();
  @Getter private HashMap<LocalDate, Ausencia> ausencias = new HashMap<>();

  public AsistenciaLaboral(
      HorarioSemanal horarioSemanal, LocalDate fechaInicio, LocalDate fechaFinal) {
    this.horarioSemanal = horarioSemanal;
    this.fechaInicio = fechaInicio;
    this.fechaFinal = fechaFinal;
  }

  public void registrarAusencia(LocalDate fecha, Ausencia ausencia) {
    eliminarAsistencia(fecha);
    eliminarAusencia(fecha);
    ausencias.put(fecha, ausencia);
  }

  public void registrarAsistencia(LocalDate fecha, Asistencia asistencia) {
    eliminarAsistencia(fecha);
    eliminarAusencia(fecha);
    asistencias.put(fecha, asistencia);
  }

  public void asignarVacaciones(LocalDate fechaInicio, LocalDate fechaFinal) {
    LocalDate fechaInicioSolapada =
        this.fechaInicio.isAfter(fechaInicio) ? this.fechaInicio : fechaInicio;
    LocalDate fechaFinalSolapada =
        this.fechaFinal.isAfter(fechaFinal) ? this.fechaFinal : fechaFinal;
    LocalDate fechaActual = fechaInicioSolapada;

    Ausencia permisoVacaciones = new Ausencia("Vacaciones", "Aprobado");
    while (!fechaActual.isAfter(fechaFinalSolapada)) {
      eliminarAusencia(fechaActual);
      eliminarAsistencia(fechaActual);
      ausencias.put(fechaActual, permisoVacaciones);
      fechaActual = fechaActual.plusDays(1);
    }
  }

  public void eliminarAsistencia(LocalDate fecha) {
    if (asistencias.containsKey(fecha)) {
      asistencias.remove(fecha);
    }
  }

  public void eliminarAusencia(LocalDate fecha) {
    if (ausencias.containsKey(fecha)) {
      ausencias.remove(fecha);
    }
  }
}
