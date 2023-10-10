package org.solid.domain.salario;

public class SalarioMensual extends Salario {
  public SalarioMensual(Double salarioBaseMensual) {
    super(salarioBaseMensual);
    calcularSalario();
  }

  @Override
  public Double calcularSalario() {
    super.setSalario(super.getSalarioBaseMensual());
    return super.getSalario();
  }
}
