package domain.salario;

public class SalarioPorSemana extends Salario {
    public SalarioPorSemana(Double salarioBaseMensual) {
        super(salarioBaseMensual);
        calcularSalario();
    }

    @Override
    public Double calcularSalario() {
        super.setSalario(super.getSalarioBaseMensual() / 4);
        return super.getSalario();
    }
}
