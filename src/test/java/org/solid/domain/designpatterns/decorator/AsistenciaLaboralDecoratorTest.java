package org.solid.domain.designpatterns.decorator;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.solid.domain.asistencia.Asistencia;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;

public class AsistenciaLaboralDecoratorTest {

    @Test
    public void testAsistenciaLaboralDecorator() {
        AsistenciaLaboralComponent mockedComponent = Mockito.mock(AsistenciaLaboralComponent.class);
        AsistenciaLaboralDecorator decorator = new AsistenciaLaboralDecorator(mockedComponent);
        decorator.registrarAsistencia(LocalDate.now(), new Asistencia());
        Mockito.verify(mockedComponent).registrarAsistencia(any(LocalDate.class), any(Asistencia.class));
    }
}
