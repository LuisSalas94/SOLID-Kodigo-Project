package domain.salario;

<<<<<<< HEAD
=======
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

>>>>>>> 16e5826 (Refactor Salario)
public class SalarioPorDia extends Salario {

    @Getter @Setter
    private Double salarioFinal;

    SalarioPorDia(Double salario) {
       super(salario);
       calcularSalario();
    }

    public SalarioPorDia(double salario) {
        super(salario);
    }

    @Override
    Double calcularSalario() {
        this.salarioFinal = super.getSalario() / 30;
        return salarioFinal;
    }
}
