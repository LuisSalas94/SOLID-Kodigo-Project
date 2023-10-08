package domain.deduccion_salarial;

import lombok.Getter;
import lombok.Setter;

public class Afp {
    @Getter @Setter
    private Double afpPorcentajeEmpleado = 7.25 / 100;

    @Getter @Setter
    private Double afpPorcentajePatronal = 7.75 / 100;
    @Getter @Setter
    private Double afpEmpleado;
    @Getter @Setter
    private Double afpPatronal;
    @Getter @Setter
    private Double salarioLiquido;

    Afp(Double salario) {
        calcularDeduccion(salario);
    }

    public Double calcularDeduccion(Double salario) {
        this.afpEmpleado = salario * afpPorcentajeEmpleado;
        this.afpPatronal = salario * afpPorcentajePatronal;
        this.salarioLiquido = salario - afpEmpleado;

        return salarioLiquido;
    }
}