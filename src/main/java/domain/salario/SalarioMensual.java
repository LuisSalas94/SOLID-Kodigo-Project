package domain.salario;

public class SalarioMensual extends Salario {

    private double salario;

    public SalarioMensual(double salario) {
        super(salario);
    }

    @Override
    double calcularSalario() {
        return salario;
    }
}
