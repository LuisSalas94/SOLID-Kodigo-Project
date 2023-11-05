package org.solid.domain.salario;

public class SalarioPorDia extends Salario {
  SalarioPorDia(Double salarioBaseMensual) {
    super(salarioBaseMensual);
    calcularSalario();
  }

  @Override
  public Double calcularSalario() {
    super.setSalario(super.getSalarioBaseMensual() / 30);
    return super.getSalario();
  }
}
