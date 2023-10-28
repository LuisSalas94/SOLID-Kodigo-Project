package org.solid.domain.salario;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SalarioMensualTest {
    @Test
    void testCalcularSalario() {
        SalarioMensual salarioMensual = new SalarioMensual(5000.0);
        double salarioMensualCalculado = salarioMensual.calcularSalario();
        assertEquals(5000.0, salarioMensualCalculado);
    }
}
