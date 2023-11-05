package org.solid.domain.deduccion_salarial;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.solid.domain.asistencia.HorasExtra;
import org.solid.domain.salario.Salario;
import java.text.DecimalFormat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DeduccionSalarialTest {


    private DeduccionSalarial deduccionSalarial;
    @Mock
    private Salario salarioBase;
    @Mock
    private Salario[] salariosExtras;
    @Mock
    private HorasExtra horasExtras;



    @BeforeEach
    public void setUp() {
        salarioBase = mock(Salario.class);
        salariosExtras = new Salario[0];
        horasExtras = mock(HorasExtra.class);

        deduccionSalarial = new DeduccionSalarial(salarioBase, salariosExtras, horasExtras);
    }

    @Test
    void testConstructorWithSalarioBaseAndSalariosExtrasAndHorasExtras() {
        Salario salarioExtra1 = mock(Salario.class);
        Salario salarioExtra2 = mock(Salario.class);

        Salario[] salariosExtras = new Salario[] {salarioExtra1, salarioExtra2};

        DeduccionSalarial deduccionSalarial = new DeduccionSalarial(salarioBase, salariosExtras, horasExtras);

        assertEquals(salarioBase, deduccionSalarial.getSalarioBase());
        assertArrayEquals(salariosExtras, deduccionSalarial.getSalariosExtras());
        assertEquals(horasExtras, deduccionSalarial.getHorasExtras());
    }

    @Test
    void testConstructorWithSalarioBaseAndHorasExtras() {
        DeduccionSalarial deduccionSalarial = new DeduccionSalarial(salarioBase, horasExtras);

        assertEquals(salarioBase, deduccionSalarial.getSalarioBase());
        assertArrayEquals(new Salario[] {}, deduccionSalarial.getSalariosExtras());
        assertEquals(horasExtras, deduccionSalarial.getHorasExtras());
    }

    @Test
    void testCalcularSalarioBruto() {
        double tarifaDiurna = 5.0;
        double tarifaNocturna = 5.0;
        when(salarioBase.getSalarioBaseMensual()).thenReturn(2000.0);
        when(horasExtras.getHorasDiurnas()).thenReturn(10);
        when(horasExtras.getHorasNocturnas()).thenReturn(5);

        deduccionSalarial.calcularSalarioBruto();

        double resultadoEsperado = 60.42 + (10 * tarifaDiurna) + (5 * tarifaNocturna);
        double resultadoActual = deduccionSalarial.getSalarioBruto();

        DecimalFormat df = new DecimalFormat("#.##");
        assertEquals(df.format(resultadoEsperado), df.format(resultadoActual));
    }



}
