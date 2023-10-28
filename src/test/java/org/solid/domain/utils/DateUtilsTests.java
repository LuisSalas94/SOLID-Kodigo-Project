package org.solid.domain.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class DateUtilsTests {
    @Mock
    private  LocalDate localDate;
    @Test
    public void testGetDayOfWeekMonday() {

        // Configurar el mock para que devuelva un DayOfWeek específico
        when(localDate.getDayOfWeek()).thenReturn(DayOfWeek.MONDAY);

        // Llamar al método getDayOfWeek de DateUtils
        Dias result = DateUtils.getDayOfWeek(localDate);

        // Comprobar que el resultado es el esperado (Dias.LUNES)
        assertEquals(Dias.Lunes, result);
    }

    @Test
    public void testGetDayOfWeekTuesday() {

        // Configurar el mock para que devuelva un DayOfWeek específico
        when(localDate.getDayOfWeek()).thenReturn(DayOfWeek.TUESDAY);

        // Llamar al método getDayOfWeek de DateUtils
        Dias result = DateUtils.getDayOfWeek(localDate);

        // Comprobar que el resultado es el esperado (Dias.LUNES)
        assertEquals(Dias.Martes, result);
    }

    @Test
    public void testGetDayOfWeekWednesday() {

        // Configurar el mock para que devuelva un DayOfWeek específico
        when(localDate.getDayOfWeek()).thenReturn(DayOfWeek.WEDNESDAY);

        // Llamar al método getDayOfWeek de DateUtils
        Dias result = DateUtils.getDayOfWeek(localDate);

        // Comprobar que el resultado es el esperado (Dias.LUNES)
        assertEquals(Dias.Miercoles, result);
    }

    @Test
    public void testGetDayOfWeekThursday() {

        // Configurar el mock para que devuelva un DayOfWeek específico
        when(localDate.getDayOfWeek()).thenReturn(DayOfWeek.THURSDAY);

        // Llamar al método getDayOfWeek de DateUtils
        Dias result = DateUtils.getDayOfWeek(localDate);

        // Comprobar que el resultado es el esperado (Dias.LUNES)
        assertEquals(Dias.Jueves, result);
    }

    @Test
    public void testGetDayOfWeekFriday() {

        // Configurar el mock para que devuelva un DayOfWeek específico
        when(localDate.getDayOfWeek()).thenReturn(DayOfWeek.FRIDAY);

        // Llamar al método getDayOfWeek de DateUtils
        Dias result = DateUtils.getDayOfWeek(localDate);

        // Comprobar que el resultado es el esperado (Dias.LUNES)
        assertEquals(Dias.Viernes, result);
    }

    @Test
    public void testGetDayOfWeekSaturday() {

        // Configurar el mock para que devuelva un DayOfWeek específico
        when(localDate.getDayOfWeek()).thenReturn(DayOfWeek.SATURDAY);

        // Llamar al método getDayOfWeek de DateUtils
        Dias result = DateUtils.getDayOfWeek(localDate);

        // Comprobar que el resultado es el esperado (Dias.LUNES)
        assertEquals(Dias.Sabado, result);
    }

    @Test
    public void testGetDayOfWeekSunday() {

        // Configurar el mock para que devuelva un DayOfWeek específico
        when(localDate.getDayOfWeek()).thenReturn(DayOfWeek.SUNDAY);

        // Llamar al método getDayOfWeek de DateUtils
        Dias result = DateUtils.getDayOfWeek(localDate);

        // Comprobar que el resultado es el esperado (Dias.LUNES)
        assertEquals(Dias.Domingo, result);
    }
}
