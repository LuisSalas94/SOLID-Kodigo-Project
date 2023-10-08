package domain.salario;


public class SalarioPorHora extends Salario {

    private int horasTrabajadas;

    public SalarioPorHora(int horasTrabajadas, double salario) {
        super(salario);
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
<<<<<<< HEAD
    double calcularSalario() {
        double pagoPorHora = (salario / 30) / 8;
=======
    Double calcularSalario() {
        double pagoPorHora = 10.0;
>>>>>>> 16e5826 (Refactor Salario)
        return horasTrabajadas * pagoPorHora;
    }
}
