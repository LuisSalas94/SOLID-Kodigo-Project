package domain.salario;

abstract public class Salario {
    double salario;

    abstract double calcularSalario();

    public Salario(double salario) {
        this.salario = salario;
    }
}
