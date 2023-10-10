package org.solid.domain.deduccion_salarial;

import org.solid.domain.asistencia.AsistenciaLaboral;
import org.solid.domain.empleado.Empleado;
import org.solid.domain.salario.Salario;
import lombok.Getter;
import lombok.Setter;

public class NominaSalarial {
    @Getter @Setter
    private Empleado empleado;
    @Getter @Setter
    private Salario salario;
    @Getter @Setter
    private AsistenciaLaboral asistenciaLaboral;
    @Getter @Setter
    private DeduccionSalarial deduccionSalarial;
    @Getter @Setter
    private String vigencia;
}
