package domain.salario;

import lombok.Getter;
import lombok.Setter;

public class SalarioQuincenal extends Salario {

    @Getter @Setter
    private Double salario;

    public SalarioQuincenal(Double salarioBaseMensual) {
        super(salarioBaseMensual);
    }

    @Override
    Double calcularSalario() {
        salario = super.getSalarioBaseMensual() / 2;
        return salario;
    }
}
