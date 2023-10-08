package domain.salario;

public class SalarioPorSemana extends Salario {

    private double salario;

    public SalarioPorSemana(double salario) {
        super(salario);
    }

    @Override
    Double calcularSalario() {
        return salario / 4;
    }
}
