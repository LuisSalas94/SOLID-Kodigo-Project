package domain.asistencia;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.HashMap;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AsistenciaSemanal extends Asistencia{
    private HashMap<DayOfWeek, AsistenciaHorario> asistencias;
    private HashMap<DayOfWeek, Ausencia> ausencias;

    @Override
    public HorasExtra calcularHorasExtras(int año, int mes, double horasRegulares) {
        LocalDate fechaInicio = LocalDate.of(año, mes, 1).with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
        LocalDate fechaFinal = fechaInicio.plusDays(6); // Intervalo semanal de lunes a domingo

        int horasDiurnas = 0;
        int horasNocturnas = 0;

        while (!fechaFinal.isAfter(LocalDate.of(año, mes, 31))) {
            LocalDate fechaActual = fechaInicio;
            while (!fechaActual.isAfter(fechaFinal)) {
                if (!ausencias.containsKey(fechaActual)) {
                    if (horaDiurna(LocalTime.from(fechaActual))) {
                        horasDiurnas += horasRegulares;
                    } else {
                        horasNocturnas += horasRegulares;
                    }
                }
                fechaActual = fechaActual.plusDays(1);
            }
            fechaInicio = fechaInicio.plusDays(7); // Avanzar al siguiente período semanal
            fechaFinal = fechaFinal.plusDays(7);
        }

        HorasExtra horasExtra = new HorasExtra();
        horasExtra.setHorasDiurnas(horasDiurnas);
        horasExtra.setHorasNocturnas(horasNocturnas);

        return horasExtra;
    }


    private boolean horaDiurna(LocalTime hora) {
        // Supongamos que las horas diurnas son entre las 6:00 AM y las 6:00 PM
        return hora.isAfter(LocalTime.of(6, 0)) && hora.isBefore(LocalTime.of(18, 0));
    }

    public void asignarVacaciones(DayOfWeek[] dias){
        for (DayOfWeek d: dias) {
            ausencias.put(d,new Ausencia("Vacaciones", "Aprobado"));
        }
    }
    public void registrarAusencia(DayOfWeek day, Ausencia ausencia){
        ausencias.put(day,ausencia);

    }
    public void registrarAsistencia(DayOfWeek day, AsistenciaHorario asistencia){
        asistencias.put(day,asistencia);
    }
}
