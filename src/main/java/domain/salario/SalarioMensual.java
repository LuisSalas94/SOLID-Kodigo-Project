package domain.salario;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SalarioMensual extends Salario {

    private double salario;

    @Override
    double calcularSalario() {
        return salario;
    }
}
