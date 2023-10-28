package org.solid.domain.empleado;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmpleadoTest {

    @Test
    public void testEmpleado() {
        Empleado empleado = new Empleado();
        // Setting values to the Empleado object
        empleado.setNombres("Fernando");
        empleado.setApellidos("Salas");
        empleado.setFechaNacimiento(LocalDate.of(1990, 5, 15));
        empleado.setDireccion("Calle 123");
        empleado.setContacto("email@example.com");
        empleado.setFechaContrato(LocalDate.of(2021, 10, 1));

        // Getting and verifying the values
        assertEquals("Fernando", empleado.getNombres());
        assertEquals("Salas", empleado.getApellidos());
        assertEquals(LocalDate.of(1990, 5, 15), empleado.getFechaNacimiento());
        assertEquals("Calle 123", empleado.getDireccion());
        assertEquals("email@example.com", empleado.getContacto());
        assertEquals(LocalDate.of(2021, 10, 1), empleado.getFechaContrato());
    }

    @Test
    public void testMockEmpleado() {
        // Creating a mocked Empleado object
        Empleado empleado = Mockito.mock(Empleado.class);

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
