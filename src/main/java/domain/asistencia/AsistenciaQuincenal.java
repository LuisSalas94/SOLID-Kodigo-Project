package domain.asistencia;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashMap;
import java.util.Timer;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AsistenciaQuincenal extends Asistencia{
    private HashMap<Date, AsistenciaHorario> asistencias;
    private HashMap<Date, Ausencia> ausencias;

    @Override
    public HorasExtra calcularHorasExtras() {
        return new HorasExtra();
    }
    public void asignarVacaciones(Timer periodo){
        System.out.println("Vacaciones asignadas para el período: " + periodo);

    }
    public void registrarAusencia(Date fecha, Ausencia ausencia){
        ausencias.put(fecha,ausencia);
    }

    public void registrarAsistencia(Date fecha, AsistenciaHorario asistencia){
        asistencias.put(fecha,asistencia);
    }
}
