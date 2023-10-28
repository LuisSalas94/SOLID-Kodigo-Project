package org.solid.domain.horario;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.solid.domain.utils.Dias;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalTime;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class HorarioTests {
    @Mock
    private HorarioSemanal horarioSemanal;
    @Mock
    private Dias dia;

    @Test
    void agregarHorarioEnHorarioSemanalDeberiaFuncional(){
        HorarioDiario horarioDiario = new HorarioDiario("Horario x", "Descripcion x", LocalTime.of(8,0), LocalTime.of(18,0));

        when(horarioSemanal.agregarHorario(eq(dia), any(HorarioDiario.class))).thenReturn(true);
        boolean resultado = horarioSemanal.agregarHorario(dia, horarioDiario);

        assertTrue(resultado);
        verify(horarioSemanal, times(1)).agregarHorario(eq(dia), any(HorarioDiario.class));
    }

    @Test
    void eliminarHorarioEnHorarioSemanalDeberiaFuncionar() {
        when(horarioSemanal.eliminarHorario(eq(dia))).thenReturn(true);

        boolean resultado = horarioSemanal.eliminarHorario(dia);

        assertTrue(resultado);
        verify(horarioSemanal, times(1)).eliminarHorario(eq(dia));
    }

    @Test
    void eliminarHorarioInexistenteEnHorarioSemanalDeberiaFallar() {
        when(horarioSemanal.eliminarHorario(eq(dia))).thenReturn(false);

        boolean resultado = horarioSemanal.eliminarHorario(dia);

        assertFalse(resultado);
        verify(horarioSemanal, times(1)).eliminarHorario(eq(dia));
    }

    @Test
    void sustituirHorarioEnHorarioSemanalDeberiaFuncionar() {
        HorarioDiario horarioDiario = new HorarioDiario("Horario x", "Descripcion x", LocalTime.of(10, 0), LocalTime.of(18, 0));

        when(horarioSemanal.sustituirHorario(eq(dia), any(HorarioDiario.class))).thenReturn(true);
        boolean resultado = horarioSemanal.sustituirHorario(dia, horarioDiario);

        assertTrue(resultado);
        verify(horarioSemanal, times(1)).sustituirHorario(eq(dia), any(HorarioDiario.class));
    }

/*    @Test
    void agregarOSustituirHorarioEnHorarioSemanalDeberiaFuncionar() {
        HorarioDiario horarioDiario = new HorarioDiario("Horario x", "Descripcion x ", LocalTime.of(8, 0), LocalTime.of(16, 0));

        when(horarioSemanal.sustituirHorario(eq(dia), any(HorarioDiario.class))).thenReturn(true);
        when(horarioSemanal.agregarHorario(eq(dia), any(HorarioDiario.class))).thenReturn(true);

        horarioSemanal.agregarOSustituirHorario(dia, horarioDiario);

        verify(horarioSemanal, times(1)).sustituirHorario(eq(dia), any(HorarioDiario.class));
        verify(horarioSemanal, never()).agregarHorario(eq(dia), any(HorarioDiario.class));
    }*/
}
