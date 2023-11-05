package org.solid.domain.designpatterns.factory;

import org.solid.domain.salario.*;

import java.util.HashMap;
import java.util.Map;

public class SalarioFactory {
    static final Map<String, Class<? extends Salario>> tipoSalario = new HashMap<>();

    static {
        tipoSalario.put("SalarioPorHora", SalarioPorHora.class);
        tipoSalario.put("SalarioPorDia", SalarioPorDia.class);
        tipoSalario.put("SalarioPorSemana", SalarioPorSemana.class);
        tipoSalario.put("SalarioQuincenal", SalarioQuincenal.class);
        tipoSalario.put("SalarioMensual", SalarioMensual.class);
        tipoSalario.put("SalarioHoraExtra",SalarioHoraExtra.class);
    }
    public static Salario crearSalario(Double salarioBaseMensual, String tipo) {
        Class<? extends Salario> salarioClass = tipoSalario.get(tipo);
        if (salarioClass != null) {
            try {
                return salarioClass.getDeclaredConstructor(Double.class).newInstance(salarioBaseMensual);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
