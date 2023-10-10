package org.solid.domain.deduccion_salarial;

import lombok.Getter;
import lombok.Setter;

public class Isss {
  @Getter @Setter private Double isssPorcentajeEmpleado = 3.0 / 100.0;
  @Getter @Setter private Double isssPorcentajePatronal = 7.5 / 100.0;
  @Getter @Setter private Double isssEmpleado;
  @Getter @Setter private Double isssPatronal;
  @Getter @Setter private Double salarioLiquido;

  Isss(Double salario) {
    calcularDeduccion(salario);
  }

  public Double calcularDeduccion(Double salario) {
    Double salarioPreIsss = salario;
    if (salario >= 1000.0) {
      salarioPreIsss = 1000.0;
    }
    this.isssEmpleado = salarioPreIsss * isssPorcentajeEmpleado;
    this.isssPatronal = salarioPreIsss * isssPorcentajePatronal;
    this.salarioLiquido = salarioPreIsss - isssEmpleado;

    return salarioLiquido;
  }
}
