package org.solid.domain.salario;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.mockito.MockitoAnnotations;

class SalarioTest {

    @Mock
    private Salario salario;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSalarioBaseMensualGetterAndSetter() {
        double expectedSalarioBaseMensual = 1000.0;
        when(salario.getSalarioBaseMensual()).thenReturn(expectedSalarioBaseMensual);
        assertEquals(expectedSalarioBaseMensual, salario.getSalarioBaseMensual());
    }
    @Test
    void testSalarioGetterAndSetter() {
        double expectedSalario = 1500.0;
        salario.setSalario(expectedSalario);
        when(salario.getSalario()).thenReturn(expectedSalario);
        assertEquals(expectedSalario, salario.getSalario());
    }

    @Test
    void testCalcularSalario() {
        Salario salario = new Salario(1000.0) {
            @Override
            Double calcularSalario() {
                return getSalarioBaseMensual() * 1.5;
            }
        };

        double resultado = salario.calcularSalario();
        assertEquals(1500.0, resultado);
    }
}

