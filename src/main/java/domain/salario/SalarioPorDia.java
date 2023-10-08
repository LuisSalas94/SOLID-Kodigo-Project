package domain.salario;

public class SalarioPorDia extends Salario {

    private double salario;

    public SalarioPorDia(double salario) {
        super(salario);
    }

    @Override
    double calcularSalario() {
        return salario / 30;
    }
}
