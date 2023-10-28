package org.solid.domain.empleado;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;

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
}
