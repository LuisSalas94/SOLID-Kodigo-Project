package domain.salario;

import lombok.Getter;
import lombok.Setter;

public class SalarioPorDia extends Salario {

    @Getter @Setter
    private Double salario;

    SalarioPorDia(Double salarioBaseMensual) {
       super(salarioBaseMensual);
       calcularSalario();
    }

    @Override
    Double calcularSalario() {
        this.salario = super.getSalarioBaseMensual() / 30;
        return salario;
    }
}
