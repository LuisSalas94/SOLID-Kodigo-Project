package domain.salario;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SalarioPorSemana extends Salario {

    private double salario;

    @Override
    double calcularSalario() {
        return salario / 4;
    }
}
