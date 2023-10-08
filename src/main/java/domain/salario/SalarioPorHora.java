package domain.salario;


import lombok.Getter;
import lombok.Setter;

public class SalarioPorHora extends Salario {

    @Getter @Setter
    private int horasTrabajadas;

    SalarioPorHora(Double salarioBaseMensual, int horasTrabajadas) {
        super(salarioBaseMensual);
        this.horasTrabajadas = horasTrabajadas;
        calcularSalario();
    }

    @Override
    Double calcularSalario() {
        double pagoPorHora = (super.getSalarioBaseMensual() / 30) / 8;
        return horasTrabajadas * pagoPorHora;
    }
}
