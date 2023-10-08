package domain.salario;

public class SalarioMensual extends Salario {

    private double salario;

<<<<<<< HEAD
    public SalarioMensual(double salario) {
=======
    SalarioMensual(Double salario) {
>>>>>>> 16e5826 (Refactor Salario)
        super(salario);
    }

    @Override
    Double calcularSalario() {
        return salario;
    }
}
