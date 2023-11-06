package org.solid.domain.deduccion_salarial;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RentaTest {

  @Mock
  private Renta renta;

  @BeforeEach
  public void setUp() {
  }

  @Test
  void testAplicarPrimerTramo() {
    when(renta.aplicarPrimerTramo(100.0)).thenCallRealMethod();
    Double salarioLiquido = renta.aplicarPrimerTramo(100.0);
    assertEquals(100.0, salarioLiquido, 0.01);
  }

  @Test
  void testAplicarSegundoTramo() {
    when(renta.aplicarSegundoTramo(600.0)).thenCallRealMethod();
    Double salarioLiquido = renta.aplicarSegundoTramo(600.0);
    assertEquals(569.53, salarioLiquido, 0.01);
  }

  @Test
  void testAplicarTercerTramo() {
    when(renta.aplicarTercerTramo(1200.0)).thenCallRealMethod();
    Double salarioLiquido = renta.aplicarTercerTramo(1200.0);
    assertEquals(1079.048, salarioLiquido, 0.01);
  }

  @Test
  void testAplicarCuartoTramo() {
    when(renta.aplicarCuartoTramo(2500.0)).thenCallRealMethod();
    Double salarioLiquido = renta.aplicarCuartoTramo(2500.0);
    assertEquals(2072.86, salarioLiquido, 0.01);
  }

  @Test
  void testAplicarRetencion_PrimerTramo() {
    renta.aplicarRetencion();
    assertEquals(0.0, renta.getRetencion(), 0.01);
  }

  @Test
  void testCalcularDeduccion_PrimerTramo() {
    renta.calcularDeduccion();
    assertEquals(0.0, renta.getRetencion(), 0.01);
  }
}
