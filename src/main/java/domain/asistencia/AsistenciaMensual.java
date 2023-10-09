package domain.asistencia;

import domain.empleado.Empleado;
import domain.horario.HorarioSemanal;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Timer;

public class AsistenciaMensual extends Asistencia{
    private HashMap<LocalDate, AsistenciaHorario> asistencias;
    private HashMap<LocalDate, Ausencia> ausencias;

    public AsistenciaMensual(Empleado empleado, HorarioSemanal horarioSemanal, LocalDate fechaInicio, LocalDate fechaFinal) {
        super(empleado, horarioSemanal, fechaInicio, fechaFinal);
        asistencias = new HashMap<LocalDate, AsistenciaHorario>();
        ausencias = new HashMap<LocalDate, Ausencia>();
    }

    @Override
    public HorasExtra calcularHorasExtras() {

        return new HorasExtra();
    }

    public void asignarVacaciones(LocalDate fechaInicio, LocalDate fechaFin) {


    }

    public void registrarAusencia(LocalDate fecha, Ausencia ausencia) {
        ausencias.put(fecha, ausencia);
    }

    public void registrarAsistencia(LocalDate fecha, AsistenciaHorario asistencia) {
        asistencias.put(fecha, asistencia);
    }

}
