package org.solid.domain.salario;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalarioPorHoraTest {
    @Test
    void testCalcularSalario() {
        SalarioPorHora salarioPorHora = new SalarioPorHora(3000.0);
        double salarioPorHoraCalculado = salarioPorHora.calcularSalario();
        assertEquals(12.5, salarioPorHoraCalculado, 0.01);
    }
}
