package org.solid.domain.horario;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.solid.domain.utils.Dias;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalTime;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class HorarioTests {
    @Mock
    private Horario horario;
    @Mock
    private HorarioDiario horarioDiario;
    @Mock
    private HorarioSemanal horarioSemanal;
    private HorarioSemanal semanal;
    @Mock
    private Dias dia;

/*    @Test
    void testEmptyConstructor(){
        assertNull(horario.getNombre());
        assertNull(horario.getDescripcion());

    }
    @Test
    void testConstructor(){

    }*/

    @BeforeEach
    void setUp() {
        semanal= new HorarioSemanal("Nombre", "Descripción");
    }

    @Test
    public void testSetterAndGetterName() {
        horario = new HorarioDiario();
        // Establece un valor para el nombre usando el método setter
        horario.setNombre("Martes");

        // Verifica que el método getter devuelve el valor correcto
        assertEquals("Martes", horario.getNombre());
    }

    @Test
    public void testSetterAndGetterDescription() {
        horario = new HorarioDiario();
        // Establece un valor para la descripción usando el método setter
        horario.setDescripcion("Reunión de equipo");

        // Verifica que el método getter devuelve el valor correcto
        assertEquals("Reunión de equipo", horario.getDescripcion());
    }

    @Test
    public void testSetterAndGetterEntrada(){
        // Establece un valor para la descripción usando el método setter
        horarioDiario = new HorarioDiario("Horario x", "Descripcion x", LocalTime.of(10, 0), LocalTime.of(18, 0));

        // Verifica que el método getter devuelve el valor correcto
        assertEquals(LocalTime.of(10,0,0), horarioDiario.getEntrada());
    }

    @Test
    public void testSetterAndGetterSalida(){
        horarioDiario = new HorarioDiario("Horario x", "Descripcion x", LocalTime.of(10, 0), LocalTime.of(16, 39));

        // Establece un valor para la descripción usando el método setter
        horarioDiario.setSalida(LocalTime.of(16,39,0));

        // Verifica que el método getter devuelve el valor correcto
        assertEquals(LocalTime.of(16,39,0), horarioDiario.getSalida());
    }

    @Test
    void testGetHorario() {
        // Arrange
        HashMap<Dias, HorarioDiario> expectedHorario = new HashMap<>();
        // Agregar elementos al horario esperado para la comparación
        expectedHorario.put(dia, horarioDiario);

        semanal.setHorario(expectedHorario);
        HashMap<Dias, HorarioDiario> hor = semanal.getHorario();

        // Act & Assert
        assertEquals(expectedHorario, hor);
    }

    @Test
    void testAgregarHorario(){
        HorarioDiario horarioDiario = new HorarioDiario("Horario x", "Descripcion x", LocalTime.of(8,0), LocalTime.of(18,0));

        when(horarioSemanal.agregarHorario(eq(dia), any(HorarioDiario.class))).thenReturn(true);
        boolean resultado = horarioSemanal.agregarHorario(dia, horarioDiario);

        assertTrue(resultado);
        verify(horarioSemanal, times(1)).agregarHorario(eq(dia), any(HorarioDiario.class));
    }

    @Test
    void testAgregarHorarioDebeFallar(){

        when(horarioSemanal.agregarHorario(eq(dia), any(HorarioDiario.class))).thenReturn(false);
        boolean resultado = horarioSemanal.agregarHorario(dia, horarioDiario);

        assertFalse(resultado);
        verify(horarioSemanal, times(1)).agregarHorario(eq(dia), any(HorarioDiario.class));
    }

    @Test
    void testEliminarHorario() {
        when(horarioSemanal.eliminarHorario(eq(dia))).thenReturn(true);

        boolean resultado = horarioSemanal.eliminarHorario(dia);

        assertTrue(resultado);
        verify(horarioSemanal, times(1)).eliminarHorario(eq(dia));
    }

    @Test
    void testEliminarHorarioDebeFallar() {
        when(horarioSemanal.eliminarHorario(eq(dia))).thenReturn(false);

        boolean resultado = horarioSemanal.eliminarHorario(dia);

        assertFalse(resultado);
        verify(horarioSemanal, times(1)).eliminarHorario(eq(dia));
    }

    @Test
    void sustituirHorario() {

        when(horarioSemanal.sustituirHorario(eq(dia), any(HorarioDiario.class))).thenReturn(true);
        boolean resultado = horarioSemanal.sustituirHorario(dia, horarioDiario);

        assertTrue(resultado);
        verify(horarioSemanal, times(1)).sustituirHorario(eq(dia), any(HorarioDiario.class));
    }

    @Test
    void sustituirHorarioDebeFallar() {

        when(horarioSemanal.sustituirHorario(eq(dia), any(HorarioDiario.class))).thenReturn(false);
        boolean resultado = horarioSemanal.sustituirHorario(dia, horarioDiario);

        assertFalse(resultado);
        verify(horarioSemanal, times(1)).sustituirHorario(eq(dia), any(HorarioDiario.class));
    }

    @Test
    void agregarOSustituirHorarioAgregar() {

        horarioSemanal.agregarOSustituirHorario(dia, horarioDiario);

        verify(horarioSemanal, never()).agregarHorario(eq(dia), any(HorarioDiario.class));
    }

    @Test
    void agregarOSustituirHorarioSubstituir() {
        when(horarioSemanal.getHorario()).thenReturn(new HashMap<>());
        horarioSemanal.getHorario().put(dia, horarioDiario);

        horarioSemanal.agregarOSustituirHorario(dia,horarioDiario);
        verify(horarioSemanal).agregarOSustituirHorario(eq(dia), eq(horarioDiario));
    }
}
