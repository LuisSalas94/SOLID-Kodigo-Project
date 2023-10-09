package domain.asistencia;

import domain.empleado.Empleado;
import domain.horario.HorarioSemanal;

import java.util.Date;
import java.util.HashMap;
import java.util.Timer;

public class AsistenciaMensual extends Asistencia{
    private HashMap<Date, AsistenciaHorario> asistencias;
    private HashMap<Date, Ausencia> ausencias;

    public AsistenciaMensual(Empleado empleado, HorarioSemanal horarioSemanal, Date fechaInicio, Date fechaFinal) {
        super(empleado, horarioSemanal, fechaInicio, fechaFinal);
        asistencias = new HashMap<>();
        ausencias = new HashMap<>();
    }

    @Override
    public HorasExtra calcularHorasExtras() {

        return new HorasExtra();
    }

    public void asignarVacaciones(Timer periodo) {
        System.out.println("Vacaciones asignadas para el período: " + periodo);

    }

    public void registrarAusencia(Date fecha, Ausencia ausencia) {
        ausencias.put(fecha, ausencia);
    }

    public void registrarAsistencia(Date fecha, AsistenciaHorario asistencia) {
        asistencias.put(fecha, asistencia);
    }

}
