package org.solid.domain.empleado;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class EmpleadoTest {
    // Creating a mocked Empleado object
    @Mock
    private Empleado empleado;

    @Test
    public void testMockEmpleado() {

        // Setting values using setters
        Mockito.when(empleado.getNombres()).thenReturn("Fernando");
        Mockito.when(empleado.getApellidos()).thenReturn("Salas");
        Mockito.when(empleado.getFechaNacimiento()).thenReturn(LocalDate.of(1990, 5, 15));
        Mockito.when(empleado.getDireccion()).thenReturn("Calle 123");
        Mockito.when(empleado.getContacto()).thenReturn("email@example.com");
        Mockito.when(empleado.getFechaContrato()).thenReturn(LocalDate.of(2021, 10, 1));

        // Getting and verifying the values
        assertEquals("Fernando", empleado.getNombres());
        assertEquals("Salas", empleado.getApellidos());
        assertEquals(LocalDate.of(1990, 5, 15), empleado.getFechaNacimiento());
        assertEquals("Calle 123", empleado.getDireccion());
        assertEquals("email@example.com", empleado.getContacto());
        assertEquals(LocalDate.of(2021, 10, 1), empleado.getFechaContrato());
    }
}
