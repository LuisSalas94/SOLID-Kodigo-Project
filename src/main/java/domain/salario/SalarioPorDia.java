package domain.salario;

import lombok.Getter;
import lombok.Setter;

public class SalarioPorDia extends Salario {

    @Getter @Setter
    private Double salarioFinal;

    SalarioPorDia(Double salario) {
       super(salario);
       calcularSalario();
    }

    public SalarioPorDia(double salario) {
        super(salario);
    }

    @Override
    Double calcularSalario() {
        this.salarioFinal = super.getSalario() / 30;
        return salarioFinal;
    }
}
