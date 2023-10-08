package domain.salario;

public class SalarioMensual extends Salario {

    private double salario;

    SalarioMensual(Double salario) {
        super(salario);
    }

    @Override
    Double calcularSalario() {
        return salario;
    }
}
