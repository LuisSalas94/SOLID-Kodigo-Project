package domain.salario;

public class SalarioPorSemana extends Salario {

    private Double salario;

    SalarioPorSemana(Double salarioBaseMensual) {
        super(salarioBaseMensual);
        calcularSalario();
    }

    @Override
    Double calcularSalario() {
        salario = super.getSalarioBaseMensual() / 4;
        return salario;
    }
}
