package org.solid.domain.deduccion_salarial;

import lombok.Getter;
import lombok.Setter;

public class Renta implements IDeduccion {
  @Getter @Setter private Integer tramo;
  @Getter @Setter private Double retencion;
  @Getter @Setter private Double salarioLiquido;
  @Getter @Setter private Double salarioPosImpuestos;

  Renta(Double salarioPosImpuestos) {
    this.salarioPosImpuestos = salarioPosImpuestos;
    calcularDeduccion();
  }

  public void calcularDeduccion() {
    aplicarRetencion();
  }

  private Double aplicarRetencion() {
    Double salario = this.salarioPosImpuestos;
    if (salario >= 0.01 && salario <= 472.00) {
      tramo = 1;
      return aplicarPrimerTramo(salario);
    }
    if (salario >= 472.01 && salario <= 895.24) {
      tramo = 2;
      return aplicarSegundoTramo(salario);
    }
    if (salario >= 895.25 && salario <= 2038.10) {
      tramo = 3;
      return aplicarTercerTramo(salario);
    }
    if (salario >= 2038.11) {
      tramo = 4;
      return aplicarCuartoTramo(salario);
    }
    return null;
  }

  private Double aplicarPrimerTramo(Double salario) {
    retencion = 0.0;
    salarioLiquido = salario;
    return salarioLiquido;
  }

  private Double aplicarSegundoTramo(Double salario) {
    retencion = ((salario - 472.00) * 0.1) + 17.67;
    salarioLiquido = salario - retencion;
    return salarioLiquido;
  }

  private Double aplicarTercerTramo(Double salario) {
    retencion = ((salario - 895.24) * 0.2) + 60.00;
    salarioLiquido = salario - retencion;
    return salarioLiquido;
  }

  private Double aplicarCuartoTramo(Double salario) {
    retencion = ((salario - 2038.10) * 0.3) + 288.57;
    salarioLiquido = salario - retencion;
    return salarioLiquido;
  }
}
