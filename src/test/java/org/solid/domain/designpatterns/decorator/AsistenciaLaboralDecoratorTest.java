package org.solid.domain.designpatterns.decorator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.solid.domain.asistencia.Asistencia;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class AsistenciaLaboralDecoratorTest {
    @Mock
    AsistenciaLaboralComponent mockedComponent;

    @Test
    public void testAsistenciaLaboralDecorator() {
        AsistenciaLaboralDecorator decorator = new AsistenciaLaboralDecorator(mockedComponent);
        decorator.registrarAsistencia(LocalDate.now(), new Asistencia());
        Mockito.verify(mockedComponent).registrarAsistencia(any(LocalDate.class), any(Asistencia.class));
    }
}
