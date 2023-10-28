package org.solid.domain.salario;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SalarioQuincenalTest {
    @Test
    void testCalcularSalario() {
        SalarioQuincenal salarioQuincenal = new SalarioQuincenal(6000.0);
        double salarioQuincenalCalculado = salarioQuincenal.calcularSalario();
        assertEquals(3000.0, salarioQuincenalCalculado);
    }
}
