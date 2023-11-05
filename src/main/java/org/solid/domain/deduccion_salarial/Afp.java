package org.solid.domain.deduccion_salarial;

import lombok.Getter;
import lombok.Setter;
import org.solid.domain.designpatterns.strategy.IDeduccion;

public class Afp implements IDeduccion {
  @Getter @Setter private Double afpPorcentajeEmpleado = 7.25 / 100.0;
  @Getter @Setter private Double afpPorcentajePatronal = 7.75 / 100.0;
  @Getter @Setter private Double afpEmpleado;
  @Getter @Setter private Double afpPatronal;
  @Getter @Setter private Double salarioLiquido;
  @Getter @Setter private Double salarioBruto;

  Afp(Double salarioBruto) {
    this.salarioBruto = salarioBruto;
    calcularDeduccion();
  }

  @Override
  public void calcularDeduccion() {
    Double salarioPreAfp = salarioBruto;
    if (salarioBruto >= 7028.29) {
      salarioPreAfp = 7028.29;
    }
    this.afpEmpleado = salarioPreAfp * afpPorcentajeEmpleado;
    this.afpPatronal = salarioPreAfp * afpPorcentajePatronal;
    this.salarioLiquido = salarioPreAfp - afpEmpleado;
    System.out.println("Deducción AFP - Empleado: " + afpEmpleado);
    System.out.println("Deducción AFP - Patronal: " + afpPatronal);

  }
}
