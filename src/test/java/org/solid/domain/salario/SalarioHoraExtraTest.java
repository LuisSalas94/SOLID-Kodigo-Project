package org.solid.domain.salario;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.mockito.Mockito;
import org.solid.domain.asistencia.HorasExtra;

class SalarioHoraExtraTest {

    private SalarioHoraExtra salarioHoraExtra;

    @BeforeEach
    public void setUp() {
        HorasExtra mockHorasExtra = mock(HorasExtra.class);
        salarioHoraExtra = new SalarioHoraExtra(1000.0, mockHorasExtra);
    }

    @Test
    void testCalcularSalario() {
        HorasExtra mockHorasExtra = Mockito.mock(HorasExtra.class);
        when(mockHorasExtra.getHorasDiurnas()).thenReturn(10);
        when(mockHorasExtra.getHorasNocturnas()).thenReturn(5);
        SalarioPorHora mockSalarioPorHora = Mockito.mock(SalarioPorHora.class);
        when(mockSalarioPorHora.getSalario()).thenReturn(20.0);
        SalarioHoraExtra salarioHoraExtra = new SalarioHoraExtra(200.0, mockHorasExtra);
        double salario = salarioHoraExtra.calcularSalario();
        assertEquals(13.541666666666668, salario);
    }

    @Test
    void testSalarioPorHorasDiurnasGetterAndSetter() {
        double expectedSalarioPorHorasDiurnas = 500.0;
        salarioHoraExtra.setSalarioPorHorasDiurnas(expectedSalarioPorHorasDiurnas);
        assertEquals(expectedSalarioPorHorasDiurnas, salarioHoraExtra.getSalarioPorHorasDiurnas());
    }

    @Test
    void testSalarioPorHorasNocturnasGetterAndSetter() {
        double expectedSalarioPorHorasNocturnas = 250.0;
        salarioHoraExtra.setSalarioPorHorasNocturnas(expectedSalarioPorHorasNocturnas);
        assertEquals(expectedSalarioPorHorasNocturnas, salarioHoraExtra.getSalarioPorHorasNocturnas());
    }

}