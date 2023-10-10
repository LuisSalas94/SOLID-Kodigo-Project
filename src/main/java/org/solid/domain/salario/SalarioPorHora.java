package org.solid.domain.salario;

public class SalarioPorHora extends Salario {

    public SalarioPorHora(Double salarioBaseMensual) {
        super(salarioBaseMensual);
        calcularSalario();
    }

    @Override
    public Double calcularSalario() {
        double pagoPorHora = (super.getSalarioBaseMensual() / 30) / 8;
        super.setSalario(pagoPorHora);
        return super.getSalario();
    }
}
