package domain.salario;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SalarioPorDia extends Salario {

    private double salario;

    @Override
    double calcularSalario() {
        return salario / 30;
    }
}
