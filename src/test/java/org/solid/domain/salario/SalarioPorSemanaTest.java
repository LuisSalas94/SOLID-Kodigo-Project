package org.solid.domain.salario;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SalarioPorSemanaTest {
    @Test
    void testCalcularSalario() {
        SalarioPorSemana salarioPorSemana = new SalarioPorSemana(4000.0);
        double salarioPorSemanaCalculado = salarioPorSemana.calcularSalario();
        assertEquals(1000.0, salarioPorSemanaCalculado);
    }
}
