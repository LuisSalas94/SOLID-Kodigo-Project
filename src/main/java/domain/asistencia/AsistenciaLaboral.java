package domain.asistencia;


import domain.horario.HorarioSemanal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;

@NoArgsConstructor
@Getter
@Setter
public class AsistenciaLaboral {
    private HorarioSemanal horarioSemanal;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private HashMap<LocalDate, Asistencia> asistencias;
    private HashMap<LocalDate, Ausencia> ausencias;
    public AsistenciaLaboral(HorarioSemanal horarioSemanal, LocalDate fechaInicio, LocalDate fechaFinal) {
        this.horarioSemanal = horarioSemanal;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.asistencias = new HashMap<>();
        this.ausencias = new HashMap<LocalDate, Ausencia>();
    }

    public void registrarAusencia(LocalDate fecha, Ausencia ausencia) {

        if (fecha.isBefore(fechaInicio) || fecha.isAfter(fechaFinal)) {
            throw new IllegalArgumentException("La fecha de ausencia está fuera del período laboral.");
        }
        if (ausencias.containsKey(fecha)) {
            throw new IllegalArgumentException("Ya existe una ausencia registrada para esta fecha.");
        }
        ausencias.put(fecha, ausencia);
    }

    public void registrarAsistencia(LocalDate fecha, Asistencia asistencia) {
        if (fecha.isBefore(fechaInicio) || fecha.isAfter(fechaFinal)) {
            throw new IllegalArgumentException("La fecha de asistencia está fuera del período laboral.");
        }
        if (asistencias.containsKey(fecha)) {
            throw new IllegalArgumentException("Ya existe una asistencia registrada para esta fecha.");
        }
        asistencias.put(fecha, asistencia);
    }

    public void asignarVacaciones(LocalDate fechaInicio, LocalDate fechaFinal) {
        if (!fechaInicio.isBefore(fechaInicio.atStartOfDay().toLocalDate()) && !fechaInicio.isAfter(fechaFinal.atStartOfDay().toLocalDate())) {
            Ausencia ausencia = new Ausencia("Vacaciones", "Aprobado");
            ausencias.put(LocalDate.from(fechaInicio.atStartOfDay(ZoneId.systemDefault()).toInstant()), ausencia);
        } else {

            System.out.println("No se pueden asignar vacaciones en esta fecha.");
        }
    }



}
