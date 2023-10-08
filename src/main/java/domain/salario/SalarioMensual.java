package domain.salario;

import lombok.Getter;
import lombok.Setter;

public class SalarioMensual extends Salario {

    @Getter @Setter
    private Double salario;

    SalarioMensual(Double salarioBaseMensual) {
        super(salarioBaseMensual);
        calcularSalario();
    }

    @Override
    Double calcularSalario() {
        salario = super.getSalarioBaseMensual();
        return salario;
    }
}
