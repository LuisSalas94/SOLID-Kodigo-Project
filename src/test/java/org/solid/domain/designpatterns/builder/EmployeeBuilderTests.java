package org.solid.domain.designpatterns.builder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.solid.domain.empleado.Empleado;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class EmployeeBuilderTests {

    @Test
    void testBuildEmpleado() {
        // Arrange
        LocalDate birthDate = LocalDate.of(2000, 8, 23);
        EmployeeBuilder builder = new EmployeeBuilder("Jorge", "Martínez", birthDate)
                .address("Calle María de Hostos #16")
                .identification("ID12345")
                .contact("jorge@example.com")
                .contractDate(LocalDate.of(2020, 8, 14));

        // Act
        Empleado empleado = builder.build();

        // Assert
        assertEquals("Jorge", empleado.getNombres());
        assertEquals("Martínez", empleado.getApellidos());
        assertEquals(birthDate, empleado.getFechaNacimiento());
        assertEquals("Calle María de Hostos #16", empleado.getDireccion());
        assertEquals("ID12345", empleado.getIdenticicacion());
        assertEquals("jorge@example.com", empleado.getContacto());
        assertEquals(LocalDate.of(2020, 8, 14), empleado.getFechaContrato());
    }

    @Test
    void testBuildEmployeeWithoutOptionalFields() {
        // Arrange
        LocalDate birthDate = LocalDate.of(2001, 4, 3);
        EmployeeBuilder builder = new EmployeeBuilder("Marcus", "Domínguez", birthDate);

        // Act
        Empleado empleado = builder.build();

        // Assert
        assertEquals("Marcus", empleado.getNombres());
        assertEquals("Domínguez", empleado.getApellidos());
        assertEquals(birthDate, empleado.getFechaNacimiento());
        assertNull( empleado.getDireccion());
        assertNull( empleado.getIdenticicacion());
        assertNull( empleado.getContacto());
        assertNull( empleado.getFechaContrato());
    }
}
