package org.solid.domain.horario;

import java.util.HashMap;
import lombok.Getter;
import org.solid.domain.utils.Dias;

public class HorarioSemanal extends Horario {

  @Getter private HashMap<Dias, HorarioDiario> horario = new HashMap<>();

  public HorarioSemanal(String nombre, String descripcion) {
    super(nombre, descripcion);
    this.horario = horario;
  }

  private boolean agregarHorario(Dias dia, HorarioDiario horarioDiario) {
    if (horario.containsKey(dia)) {
      return false;
    }
    horario.put(dia, horarioDiario);
    return true;
  }

  public boolean eliminarHorario(Dias dia) {
    if (horario.containsKey(dia)) {
      horario.remove(dia);
      return true;
    } else {
      return false;
    }
  }

  private boolean sustituirHorario(Dias dia, HorarioDiario horarioDiario) {
    if (horario.containsKey(dia)) {
      horario.put(dia, horarioDiario);
      return true;
    } else {
      return false;
    }
  }

  public void agregarOSustituirHorario(Dias dia, HorarioDiario horarioDiario) {
    horario.put(dia, horarioDiario);
  }
}
