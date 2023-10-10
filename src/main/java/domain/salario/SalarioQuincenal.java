package domain.salario;

import lombok.Getter;
import lombok.Setter;

public class SalarioQuincenal extends Salario {
    public SalarioQuincenal(Double salarioBaseMensual) {
        super(salarioBaseMensual);
        calcularSalario();
    }

    @Override
    public Double calcularSalario() {
        super.setSalario(super.getSalarioBaseMensual() / 2);
        return super.getSalario();
    }
}
