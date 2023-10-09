package domain.asistencia;


import domain.empleado.Empleado;
import domain.horario.HorarioSemanal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public abstract class Asistencia {
    private Empleado empleado;
    private HorarioSemanal horarioSemanal;
    private Date fechaInicio;
    private Date fechaFinal;
    public Asistencia(Empleado empleado, HorarioSemanal horarioSemanal, Date fechaInicio, Date fechaFinal) {
        this.empleado = empleado;
        this.horarioSemanal = horarioSemanal;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }
    public abstract HorasExtra calcularHorasExtras();

}
