package domain.salario;

import domain.asistencia.HorasExtra;
import lombok.Getter;
import lombok.Setter;

public class SalarioHoraExtra extends Salario {
    private final Double porcentajeHorasDiurnas = 100.0 / 100.0;
    private final Double porcentajeHorasNocturnas = 125.0 / 125.0;

    @Getter @Setter
    private Object horasExtras;

    @Getter
    private Double salario;

    public SalarioHoraExtra(Double salarioBaseMensual, HorasExtra horasExtras) {
        super(salarioBaseMensual);
        this.horasExtras = horasExtras;
        calcularSalario();
    }

    @Override
    Double calcularSalario() {
        return null;
    }

}
