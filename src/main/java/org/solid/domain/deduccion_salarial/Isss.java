package org.solid.domain.deduccion_salarial;

import lombok.Getter;
import lombok.Setter;

public class Isss implements IDeduccion {
  @Getter @Setter private Double isssPorcentajeEmpleado = 3.0 / 100.0;
  @Getter @Setter private Double isssPorcentajePatronal = 7.5 / 100.0;
  @Getter @Setter private Double isssEmpleado;
  @Getter @Setter private Double isssPatronal;
  @Getter @Setter private Double salarioLiquido;
  @Getter @Setter private Double salarioBruto;

  Isss(Double salarioBruto) {
    this.salarioBruto = salarioBruto;
    calcularDeduccion();
  }

  public void calcularDeduccion() {
    Double salarioPreIsss = salarioBruto;
    if (salarioBruto >= 1000.0) {
      salarioPreIsss = 1000.0;
    }
    this.isssEmpleado = salarioPreIsss * isssPorcentajeEmpleado;
    this.isssPatronal = salarioPreIsss * isssPorcentajePatronal;
    this.salarioLiquido = salarioPreIsss - isssEmpleado;
  }
}
