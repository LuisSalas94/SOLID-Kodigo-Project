package domain.salario;

import lombok.Getter;
import lombok.Setter;

abstract public class Salario {
    @Getter @Setter
    private Double salarioBaseMensual;
    @Getter @Setter
    private Double salario;

    Salario(Double salarioBaseMensual) {
        this.salarioBaseMensual = salarioBaseMensual;
    }

    abstract Double calcularSalario();
}
