package domain.asistencia;


import domain.empleado.Empleado;
import domain.horario.HorarioSemanal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public abstract class Asistencia {
    private Empleado empleado;
    private HorarioSemanal horarioSemanal;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    public Asistencia(Empleado empleado, HorarioSemanal horarioSemanal, LocalDate fechaInicio, LocalDate fechaFinal) {
        this.empleado = empleado;
        this.horarioSemanal = horarioSemanal;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }
    public abstract HorasExtra calcularHorasExtras(int año, int mes, double horas);

}
