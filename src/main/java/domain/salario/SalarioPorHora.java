package domain.salario;


public class SalarioPorHora extends Salario {

    private int horasTrabajadas;

    public SalarioPorHora(int horasTrabajadas, double salario) {
        super(salario);
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    Double calcularSalario() {
        Double pagoPorHora = (super.getSalario() / 30) / 8;
        return horasTrabajadas * pagoPorHora;
    }
}
