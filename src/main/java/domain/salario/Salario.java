package domain.salario;

import lombok.Getter;
import lombok.Setter;

<<<<<<< HEAD
    abstract double calcularSalario();

    public Salario(double salario) {
        this.salario = salario;
    }
=======
abstract public class Salario {
    @Getter @Setter
    private Double salario;

    Salario(Double salario) {
        this.salario = salario;
    }

    abstract Double calcularSalario();
>>>>>>> 16e5826 (Refactor Salario)
}
