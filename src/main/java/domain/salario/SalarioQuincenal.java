package domain.salario;

public class SalarioQuincenal extends Salario {

    private double salario;

    public SalarioQuincenal(double salario) {
        super(salario);
    }

    @Override
    Double calcularSalario() {
        return salario / 2;
    }
}
