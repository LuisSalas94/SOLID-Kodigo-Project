package domain.asistencia;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Timer;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AsistenciaQuincenal extends Asistencia{
    private HashMap<Date, AsistenciaHorario> asistencias;
    private HashMap<Date, Ausencia> ausencias;

    @Override
    public HorasExtra calcularHorasExtras(int año, int mes, double horasRegulares) {
        LocalDate fechaInicio = LocalDate.of(año, mes, 1);
        LocalDate fechaFinal = fechaInicio.plusDays(13);

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


            fechaInicio = fechaInicio.plusDays(14);
            fechaFinal = fechaFinal.plusDays(14);
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

    public void asignarVacaciones(LocalDate fechaInicio, LocalDate fechaFinal){

        if (!fechaInicio.isBefore(fechaInicio.atStartOfDay().toLocalDate()) && !fechaInicio.isAfter(fechaFinal.atStartOfDay().toLocalDate())) {
            Ausencia ausencia = new Ausencia("Vacaciones", "Aprobado");
            ausencias.put(Date.from(fechaInicio.atStartOfDay(ZoneId.systemDefault()).toInstant()), ausencia);
        } else {

            System.out.println("No se pueden asignar vacaciones en esta fecha.");
        }
    }


    public void registrarAusencia(Date fecha, Ausencia ausencia){
        ausencias.put(fecha,ausencia);
    }

    public void registrarAsistencia(Date fecha, AsistenciaHorario asistencia){
        asistencias.put(fecha,asistencia);
    }
}
