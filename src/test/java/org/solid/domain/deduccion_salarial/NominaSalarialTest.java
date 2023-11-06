package org.solid.domain.deduccion_salarial;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.solid.domain.empleado.Empleado;
import org.solid.domain.salario.SalarioMensual;

@ExtendWith(MockitoExtension.class)
class NominaSalarialTest {
  @Mock private DeduccionSalarial deduccionSalarial;

  @Test
  void testAsignarValores() {
    NominaSalarial nominaSalarial = new NominaSalarial();
    Empleado empleado =
        new Empleado(
            "Juan", "Perez", LocalDate.now(), "Quito", "1718587474", "0995655874", LocalDate.now());
    SalarioMensual salario = new SalarioMensual(1000.0);

    nominaSalarial.setEmpleado(empleado);
    nominaSalarial.setSalario(salario);

    assertEquals(empleado, nominaSalarial.getEmpleado());
    assertEquals(salario, nominaSalarial.getSalario());
  }

  @Test
  void testAsignarDeduccionSalarial() {
    NominaSalarial nominaSalarial = new NominaSalarial();
    nominaSalarial.setDeduccionSalarial(deduccionSalarial);
    assertEquals(deduccionSalarial, nominaSalarial.getDeduccionSalarial());
  }
}
