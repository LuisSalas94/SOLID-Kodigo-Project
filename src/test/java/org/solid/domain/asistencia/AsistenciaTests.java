package org.solid.domain.asistencia;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.solid.domain.horario.HorarioSemanal;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class AsistenciaTests {

    @Test
    public void testRegistrarAusencia() {
        AsistenciaLaboral asistenciaLaboral = new AsistenciaLaboral(
                new HorarioSemanal("Nombre", "Descripcion"),
                LocalDate.of(2023, 1, 1),
                LocalDate.of(2023, 12, 31)
        );
        Ausencia ausencia = new Ausencia("Enfermedad", "Aprobado");
        asistenciaLaboral.registrarAusencia(LocalDate.of(2023, 2, 1), ausencia);
        assertEquals(ausencia, asistenciaLaboral.getAusencias().get(LocalDate.of(2023, 2, 1)));
    }

    @Test
    public void testRegistrarAsistencia() {
        AsistenciaLaboral asistenciaLaboral = new AsistenciaLaboral(
                new HorarioSemanal("Nombre", "Descripcion"),
                LocalDate.of(2023, 1, 1),
                LocalDate.of(2023, 12, 31)
        );
        Asistencia asistencia = new Asistencia();
        asistencia.setHoraEntrada(LocalTime.of(8, 0));
        asistencia.setHoraSalida(LocalTime.of(16, 30));

        asistenciaLaboral.registrarAsistencia(LocalDate.of(2023, 3, 1), asistencia);

        Asistencia actualAsistencia = asistenciaLaboral.getAsistencias().get(LocalDate.of(2023, 3, 1));
        assertEquals(asistencia.getHoraEntrada(), actualAsistencia.getHoraEntrada());
        assertEquals(asistencia.getHoraSalida(), actualAsistencia.getHoraSalida());
    }

    @Test
    public void testAsignarVacaciones() {
        AsistenciaLaboral asistenciaLaboral = new AsistenciaLaboral(
                new HorarioSemanal("Nombre", "Descripcion"),
                LocalDate.of(2023, 1, 1),
                LocalDate.of(2023, 12, 31)
        );

        asistenciaLaboral.asignarVacaciones(LocalDate.of(2023, 2, 15), LocalDate.of(2023, 2, 25));

        assertTrue(asistenciaLaboral.getAusencias().containsKey(LocalDate.of(2023, 2, 15)));
        assertTrue(asistenciaLaboral.getAusencias().containsKey(LocalDate.of(2023, 2, 25)));
    }

    @Test
    public void testEliminarAsistencia() {
        AsistenciaLaboral asistenciaLaboral = new AsistenciaLaboral(
                new HorarioSemanal("Nombre", "Descripcion"),
                LocalDate.of(2023, 1, 1),
                LocalDate.of(2023, 12, 31)
        );
        Asistencia asistencia = new Asistencia();
        asistencia.setHoraEntrada(LocalTime.of(8, 0));
        asistencia.setHoraSalida(LocalTime.of(16, 30));

        asistenciaLaboral.registrarAsistencia(LocalDate.of(2023, 4, 1), asistencia);
        asistenciaLaboral.eliminarAsistencia(LocalDate.of(2023, 4, 1));
        assertNull(asistenciaLaboral.getAsistencias().get(LocalDate.of(2023, 4, 1)));
    }

    @Test
    public void testEliminarAusencia() {
        AsistenciaLaboral asistenciaLaboral = new AsistenciaLaboral(
                new HorarioSemanal("Nombre", "Descripcion"),
                LocalDate.of(2023, 1, 1),
                LocalDate.of(2023, 12, 31)
        );
        Ausencia ausencia = new Ausencia("Vacaciones", "Aprobado");
        asistenciaLaboral.registrarAusencia(LocalDate.of(2023, 5, 1), ausencia);

        asistenciaLaboral.eliminarAusencia(LocalDate.of(2023, 5, 1));

        assertNull(asistenciaLaboral.getAusencias().get(LocalDate.of(2023, 5, 1)));
    }

    @Test
    public void testAsistenciaLaboral() {
        // Mocking Asistencia and Ausencia objects
        Asistencia asistencia = Mockito.mock(Asistencia.class);
        Ausencia ausencia = Mockito.mock(Ausencia.class);

        // Mock HorarioSemanal object
        HorarioSemanal horarioSemanal = Mockito.mock(HorarioSemanal.class);

        // AsistenciaLaboral object
        AsistenciaLaboral asistenciaLaboral = new AsistenciaLaboral(horarioSemanal, LocalDate.now(), LocalDate.now().plusDays(10));

        // Asistencia
        asistenciaLaboral.registrarAsistencia(LocalDate.now().plusDays(2), asistencia);
        assertEquals(asistencia, asistenciaLaboral.getAsistencias().get(LocalDate.now().plusDays(2)));

        // Ausencia
        asistenciaLaboral.registrarAusencia(LocalDate.now().plusDays(4), ausencia);
        assertEquals(ausencia, asistenciaLaboral.getAusencias().get(LocalDate.now().plusDays(4)));

        // Asistencia
        asistenciaLaboral.eliminarAsistencia(LocalDate.now().plusDays(2));
        assertNull(asistenciaLaboral.getAsistencias().get(LocalDate.now().plusDays(2)));

        // Ausencia
        asistenciaLaboral.eliminarAusencia(LocalDate.now().plusDays(4));
        assertNull(asistenciaLaboral.getAusencias().get(LocalDate.now().plusDays(4)));
    }

}
