package domain.asistencia;

import domain.DayOfWeek;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AsistenciaSemanal extends Asistencia{
    private HashMap<DayOfWeek, AsistenciaHorario> asistencias;
    private HashMap<DayOfWeek, Ausencia> ausencias;

    @Override
    public HorasExtra calcularHorasExtras() {
        return new HorasExtra();
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
