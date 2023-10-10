package org.solid.domain.salario;

import lombok.Getter;
import lombok.Setter;
import org.solid.domain.asistencia.HorasExtra;

public class SalarioHoraExtra extends Salario {
  private final Double porcentajeHorasDiurnas = 100.0 / 100.0;
  private final Double porcentajeHorasNocturnas = 125.0 / 125.0;

  @Getter @Setter private Double salarioPorHorasNocturnas;

  @Getter @Setter private Double salarioPorHorasDiurnas;

  @Getter @Setter private HorasExtra horasExtras;

  SalarioPorHora salarioPorHora;

  public SalarioHoraExtra(Double salarioBaseMensual, HorasExtra horasExtras) {
    super(salarioBaseMensual);
    salarioPorHora = new SalarioPorHora(salarioBaseMensual);
    this.horasExtras = horasExtras;
    calcularSalario();
  }

  @Override
  public Double calcularSalario() {
    salarioPorHorasDiurnas =
        horasExtras.getHorasDiurnas() * salarioPorHora.getSalario() * porcentajeHorasDiurnas;
    salarioPorHorasNocturnas =
        horasExtras.getHorasNocturnas() * salarioPorHora.getSalario() * porcentajeHorasNocturnas;
    super.setSalario(salarioPorHorasDiurnas + salarioPorHorasNocturnas);
    return super.getSalario();
  }
}
