package org.solid.domain.salario;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalarioPorDiaTest {
    @Test
    void testCalcularSalario() {
        SalarioPorDia salarioPorDia = new SalarioPorDia(3000.0);
        double salarioPorDiaCalculado = salarioPorDia.calcularSalario();
        assertEquals(100.0, salarioPorDiaCalculado, 0.01);
    }
}
