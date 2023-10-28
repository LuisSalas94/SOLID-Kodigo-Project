package org.solid.domain.deduccion_salarial;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AfpTest {
  private Afp afp;

  @BeforeEach
  public void setUp() {
    afp = new Afp(8000.0);
  }

  @Test
  void testCalcularDeduccion() {
    afp.calcularDeduccion();
    assertEquals(
        new BigDecimal("509.55").setScale(2, RoundingMode.HALF_UP),
        BigDecimal.valueOf(afp.getAfpEmpleado()).setScale(2, RoundingMode.HALF_UP));
    assertEquals(
        new BigDecimal("544.69").setScale(2, RoundingMode.HALF_UP),
        BigDecimal.valueOf(afp.getAfpPatronal()).setScale(2, RoundingMode.HALF_UP));
    assertEquals(
        new BigDecimal("6518.74").setScale(2, RoundingMode.HALF_UP),
        BigDecimal.valueOf(afp.getSalarioLiquido()).setScale(2, RoundingMode.HALF_UP));
  }
}
