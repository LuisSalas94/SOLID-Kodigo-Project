package domain.deduccion_salarial;

import lombok.Getter;
import lombok.Setter;

public class Isss {
    @Getter @Setter
    private Double isssPorcentajeEmpleado = 3.0 / 100;
    @Getter @Setter
    private Double isssPorcentajePatronal = 7.5 / 100;
    @Getter @Setter
    private Double isssEmpleado;
    @Getter @Setter
    private Double isssPatronal;
    @Getter @Setter
    private Double salarioLiquido;

    Isss(Double salario) {
        calcularDeduccion(salario);
    }

    public Double calcularDeduccion(Double salario) {
        this.isssEmpleado = salario * isssPorcentajeEmpleado;
        this.isssPatronal = salario * isssPorcentajePatronal;
        this.salarioLiquido = salario - isssEmpleado;

        return salarioLiquido;
    }
}
