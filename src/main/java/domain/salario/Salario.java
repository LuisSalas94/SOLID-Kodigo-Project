package domain.salario;

import lombok.Getter;
import lombok.Setter;

abstract public class Salario {
    @Getter @Setter
    private Double salario;

    Salario(Double salario) {
        this.salario = salario;
    }

    abstract Double calcularSalario();
}
