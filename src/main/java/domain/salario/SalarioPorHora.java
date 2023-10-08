package domain.salario;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SalarioPorHora extends Salario {

    private int horasTrabajadas;
    @Override
    double calcularSalario() {
        double pagoPorHora = 10.0;
        return horasTrabajadas * pagoPorHora;
    }
}
