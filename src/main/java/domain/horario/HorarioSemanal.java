package domain.horario;

import domain.DayOfWeek;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

public class HorarioSemanal extends Horario {

    @Getter
    @Setter
    private HashMap<DayOfWeek, HorarioDiario> horario;

    private boolean agregarHorario(DayOfWeek dia, HorarioDiario horarioDiario) {
        if (horario.containsKey(dia)) {
            return false;
        }
        horario.put(dia, horarioDiario);
        return true;
    }

    public boolean eliminarHorario(DayOfWeek dia) {
        if (horario.containsKey(dia)) {
            horario.remove(dia);
            return true;
        } else {
            return false;
        }
    }

    private boolean sustituirHorario(DayOfWeek dia, HorarioDiario horarioDiario) {
        if (horario.containsKey(dia)) {
            horario.put(dia, horarioDiario);
            return true;
        } else {
            return false;
        }
    }

    public void agregarOSustituirHorario(DayOfWeek dia, HorarioDiario horarioDiario) {
        horario.put(dia, horarioDiario);
    }
}
