package org.solid.domain.deduccion_salarial;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class RentaTest {

  @Mock private Renta renta;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testAplicarPrimerTramo() {
    Mockito.when(renta.aplicarPrimerTramo(100.0)).thenCallRealMethod();
    Double salarioLiquido = renta.aplicarPrimerTramo(100.0);
    assertEquals(100.0, salarioLiquido, 0.01);
  }

  @Test
  void testAplicarSegundoTramo() {
    Mockito.when(renta.aplicarSegundoTramo(600.0)).thenCallRealMethod();
    Double salarioLiquido = renta.aplicarSegundoTramo(600.0);
    assertEquals(569.53, salarioLiquido, 0.01);
  }

  @Test
  void testAplicarTercerTramo() {
    Mockito.when(renta.aplicarTercerTramo(1200.0)).thenCallRealMethod();
    Double salarioLiquido = renta.aplicarTercerTramo(1200.0);
    assertEquals(1079.048, salarioLiquido, 0.01);
  }

  @Test
  void testAplicarCuartoTramo() {
    Mockito.when(renta.aplicarCuartoTramo(2500.0)).thenCallRealMethod();
    Double salarioLiquido = renta.aplicarCuartoTramo(2500.0);
    assertEquals(2072.86, salarioLiquido, 0.01);
  }

  @Test
  void testAplicarRetencion_PrimerTramo() {
    Mockito.when(renta.getSalarioPosImpuestos()).thenReturn(100.0);
    renta.aplicarRetencion();
    assertEquals(0.0, renta.getRetencion(), 0.01);
  }

  @Test
  void testCalcularDeduccion_PrimerTramo() {
    Mockito.when(renta.getSalarioPosImpuestos()).thenReturn(100.0);
    renta.calcularDeduccion();
    assertEquals(0.0, renta.getRetencion(), 0.01);
  }
}
