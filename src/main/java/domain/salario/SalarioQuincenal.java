package domain.salario;

public class SalarioQuincenal extends Salario {

    private double salario;

    public SalarioQuincenal(double salario) {
        super(salario);
    }

    @Override
    double calcularSalario() {
        return salario / 2;
    }
}
