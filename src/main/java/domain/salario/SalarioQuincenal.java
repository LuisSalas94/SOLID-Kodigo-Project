package domain.salario;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SalarioQuincenal extends Salario {

    private double salario;

    @Override
    double calcularSalario() {
        return salario / 2;
    }
}
