package org.solid.domain.designpatterns.singleton;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.solid.domain.empleado.Empleado;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeSingletonTest {
    private EmployeeSingleton employeeSingleton;
    private List<Empleado> empleadoList;

    @BeforeEach
    void setUp() {
        employeeSingleton = EmployeeSingleton.getInstance();
        empleadoList = employeeSingleton.getEmployeeList();
        empleadoList.clear(); // Limpiar la lista antes de cada prueba
    }

    @Test
    void testGetEmployee() {
        // Arrange
        Empleado employee = new Empleado("Sebastian", "Lockwood", LocalDate.of(1990, 1, 15), "123 Main St", "ID12345", "john@example.com", LocalDate.of(2023, 5, 1));
        empleadoList.add(employee);

        // Act
        Empleado foundEmployee = employeeSingleton.getEmployee("Sebastian", "Lockwood");

        // Assert
        assertNotNull(foundEmployee);
        assertEquals("Sebastian", foundEmployee.getNombres());
        assertEquals("Lockwood", foundEmployee.getApellidos());
    }

    @Test
    void testGetEmployeeNotFound() {
        // Act
        Empleado notFoundEmployee = employeeSingleton.getEmployee("Sebastian", "Lockwood");

        // Assert
        assertNull(notFoundEmployee);
    }

    @Test
    void testCreateEmployee() {
        // Arrange
        Empleado newEmployee = new Empleado("Fernanda", "Soprano", LocalDate.of(1985, 11, 9), "Nuevo Mexico", "ID12345", "fernanda@example.com", LocalDate.of(2019, 3, 30));

        // Act
        Empleado createdEmployee = employeeSingleton.createEmployee(newEmployee);

        // Assert
        assertNotNull(createdEmployee);
        assertTrue(empleadoList.contains(newEmployee));
    }

    @Test
    void testCreateEmployeeWithDuplicateID() {
        // Arrange
        Empleado existingEmployee = new Empleado("Fernanda", "Soprano", LocalDate.of(1985, 11, 9), "Nuevo Mexico", "ID12345", "fernanda@example.com", LocalDate.of(2019, 3, 30));
        empleadoList.add(existingEmployee); // Simular un empleado existente con el mismo ID
        Empleado newEmployee = new Empleado("Jane", "Pérez", LocalDate.of(1986, 5, 20), "Nuevo Mexico", "ID12345", "jane@example.com", LocalDate.of(2018, 6, 17));

        // Act
        Empleado createdEmployee = employeeSingleton.createEmployee(newEmployee);

        // Assert
        assertNull(createdEmployee); // Debe devolver null en caso de ID duplicado
        assertFalse(empleadoList.contains(newEmployee)); // El empleado no debe estar en la lista
    }

    @Test
    void testUpdateEmployee() throws Exception {
        // Arrange
        Empleado existingEmployee = new Empleado("Fernanda", "Soprano", LocalDate.of(1985, 11, 9), "Nuevo Mexico", "ID12345", "fernanda@example.com", LocalDate.of(2019, 3, 30));
        empleadoList.add(existingEmployee);
        Empleado updatedEmployee = new Empleado("Jane", "Pérez", LocalDate.of(1986, 5, 20), "Nuevo Mexico", "ID12345", "jane@example.com", LocalDate.of(2018, 6, 17));

        // Act
        Empleado result = employeeSingleton.updateEmployee(updatedEmployee);

        // Assert
        assertNotNull(result);
        assertEquals("Jane", result.getNombres());
        assertEquals("Pérez", result.getApellidos());
        assertEquals(LocalDate.of(1986, 5, 20), result.getFechaNacimiento());
        assertEquals("ID12345", result.getIdenticicacion());
        assertEquals("Nuevo Mexico", result.getDireccion());
        assertEquals("jane@example.com", result.getContacto());
        assertEquals(LocalDate.of(2018, 6, 17), result.getFechaContrato());
    }

    @Test
    void testUpdateNonExistentEmployee() {
        // Arrange
        Empleado updatedEmployee = new Empleado("Jane", "Pérez", LocalDate.of(1986, 5, 20), "Nuevo Mexico", "ID12345", "jane@example.com", LocalDate.of(2018, 6, 17));

        // Act and Assert
        assertThrows(Exception.class, () -> employeeSingleton.updateEmployee(updatedEmployee));
    }

    @Test
    void testDeleteEmployee() {
        // Arrange
        Empleado existingEmployee = new Empleado("Jane", "Pérez", LocalDate.of(1986, 5, 20), "Nuevo Mexico", "ID88889", "jane@example.com", LocalDate.of(2018, 6, 17));
        empleadoList.add(existingEmployee);
        // Act
        boolean deleted = employeeSingleton.deleteEmployee("ID88889");

        // Assert
        assertTrue(deleted);
        assertFalse(empleadoList.contains(existingEmployee));
    }

    @Test
    void testDeleteNonExistentEmployee() {
        // Act
        boolean deleted = employeeSingleton.deleteEmployee("NonExistentID");

        // Assert
        assertFalse(deleted);
    }
}
