package domain.salario;

public class SalarioPorSemana extends Salario {
    SalarioPorSemana(Double salarioBaseMensual) {
        super(salarioBaseMensual);
        calcularSalario();
    }

    @Override
    Double calcularSalario() {
        super.setSalario(super.getSalarioBaseMensual() / 4);
        return super.getSalario();
    }
}
