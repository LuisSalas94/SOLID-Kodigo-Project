package org.solid.domain.deduccion_salarial;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class IsssTest {
  @Mock
  private Isss isss;

  @BeforeEach
  void setUp() {
    isss = new Isss(1500.0);
  }

  @Test
  void testCalcularDeduccion() {
    isss.calcularDeduccion();

    assertEquals(30.0, isss.getIsssEmpleado(), 0.01);
    assertEquals(75.0, isss.getIsssPatronal(), 0.01);
    assertEquals(970.0, isss.getSalarioLiquido(), 0.01);
  }

  @Test
  void testCalcularDeduccionWithLowSalario() {
    isss = new Isss(500.0);
    isss.calcularDeduccion();

    assertEquals(15.0, isss.getIsssEmpleado(), 0.01);
    assertEquals(37.5, isss.getIsssPatronal(), 0.01);
    assertEquals(485.0, isss.getSalarioLiquido(), 0.01);
  }
}
