package org.solid.domain.salario;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.solid.domain.asistencia.HorasExtra;

@ExtendWith(MockitoExtension.class)
class SalarioTest {
    private SalarioHoraExtra salarioHoraExtra;

    @BeforeEach
    public void setUp() {
        HorasExtra mockHorasExtra = mock(HorasExtra.class);
        salarioHoraExtra = new SalarioHoraExtra(1000.0, mockHorasExtra);
    }
    @Mock
    private Salario salario;

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

    @Test
    void testCalcularSalarioQuincenal() {
        SalarioQuincenal salarioQuincenal = new SalarioQuincenal(6000.0);
        double salarioQuincenalCalculado = salarioQuincenal.calcularSalario();
        assertEquals(3000.0, salarioQuincenalCalculado);
    }

    @Test
    void testCalcularSalarioPorSemana() {
        SalarioPorSemana salarioPorSemana = new SalarioPorSemana(4000.0);
        double salarioPorSemanaCalculado = salarioPorSemana.calcularSalario();
        assertEquals(1000.0, salarioPorSemanaCalculado);
    }

    @Test
    void testCalcularSalarioPorHora() {
        SalarioPorHora salarioPorHora = new SalarioPorHora(3000.0);
        double salarioPorHoraCalculado = salarioPorHora.calcularSalario();
        assertEquals(12.5, salarioPorHoraCalculado, 0.01);
    }

    @Test
    void testCalcularSalarioPorDia() {
        SalarioPorDia salarioPorDia = new SalarioPorDia(3000.0);
        double salarioPorDiaCalculado = salarioPorDia.calcularSalario();
        assertEquals(100.0, salarioPorDiaCalculado, 0.01);
    }

    @Test
    void testCalcularSalarioMensual() {
        SalarioMensual salarioMensual = new SalarioMensual(5000.0);
        double salarioMensualCalculado = salarioMensual.calcularSalario();
        assertEquals(5000.0, salarioMensualCalculado);
    }

    @Test
    void testCalcularSalarioHoraExtra() {
        HorasExtra mockHorasExtra = Mockito.mock(HorasExtra.class);
        when(mockHorasExtra.getHorasDiurnas()).thenReturn(10);
        when(mockHorasExtra.getHorasNocturnas()).thenReturn(5);
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

