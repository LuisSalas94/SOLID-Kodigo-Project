package org.solid.domain.salario;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public abstract class Salario {
  private Double salarioBaseMensual;
  private Double salario;

  Salario(Double salarioBaseMensual) {
    this.salarioBaseMensual = salarioBaseMensual;
  }

  public abstract Double calcularSalario();


}
