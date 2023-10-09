package domain.salario;

public class SalarioMensual extends Salario {
    SalarioMensual(Double salarioBaseMensual) {
        super(salarioBaseMensual);
        calcularSalario();
    }

    @Override
    Double calcularSalario() {
        super.setSalario(super.getSalarioBaseMensual());
        return super.getSalario();
    }
}
