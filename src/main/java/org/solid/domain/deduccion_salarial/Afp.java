package org.solid.domain.deduccion_salarial;

import lombok.Getter;
import lombok.Setter;

public class Afp {
  @Getter @Setter private Double afpPorcentajeEmpleado = 7.25 / 100.0;
  @Getter @Setter private Double afpPorcentajePatronal = 7.75 / 100.0;
  @Getter @Setter private Double afpEmpleado;
  @Getter @Setter private Double afpPatronal;
  @Getter @Setter private Double salarioLiquido;

  Afp(Double salario) {
    calcularDeduccion(salario);
  }

  public Double calcularDeduccion(Double salario) {
    Double salarioPreAfp = salario;
    if (salario >= 7028.29) {
      salarioPreAfp = 7028.29;
    }
    this.afpEmpleado = salarioPreAfp * afpPorcentajeEmpleado;
    this.afpPatronal = salarioPreAfp * afpPorcentajePatronal;
    this.salarioLiquido = salarioPreAfp - afpEmpleado;

    return salarioLiquido;
  }
}
