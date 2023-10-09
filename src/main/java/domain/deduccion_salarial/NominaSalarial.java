package domain.deduccion_salarial;

import domain.asistencia.Asistencia;
import domain.empleado.Empleado;
import domain.salario.Salario;
import lombok.Getter;
import lombok.Setter;

public class NominaSalarial {
    @Getter @Setter
    private Empleado empleado;
    @Getter @Setter
    private Salario salario;
    @Getter @Setter
    private Asistencia asistencia;
    @Getter @Setter
    private DeduccionSalarial deduccionSalarial;
    @Getter @Setter
    private String vigencia;
}
