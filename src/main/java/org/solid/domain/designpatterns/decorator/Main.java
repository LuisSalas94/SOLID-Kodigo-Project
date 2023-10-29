package org.solid.domain.designpatterns.decorator;

import org.solid.domain.asistencia.Asistencia;
import org.solid.domain.asistencia.AsistenciaLaboral;
import org.solid.domain.asistencia.Ausencia;
import org.solid.domain.horario.HorarioSemanal;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        // Create an instance of the HorarioSemanal
        HorarioSemanal horarioSemanal = new HorarioSemanal("Horario Semanal", "Description");

        // Create an instance of the AsistenciaLaboral with the HorarioSemanal instance
        AsistenciaLaboral asistenciaLaboral = new AsistenciaLaboral(horarioSemanal, LocalDate.now(), LocalDate.now());

        // Decorate the base component
        AsistenciaLaboralComponent decoratedAsistenciaLaboral = new AsistenciaLaboralDecorator(asistenciaLaboral);

        // Test the decorated methods
        decoratedAsistenciaLaboral.registrarAusencia(LocalDate.now(), new Ausencia("Sickness", "Pending"));
        decoratedAsistenciaLaboral.registrarAsistencia(LocalDate.now(), new Asistencia(LocalTime.now(), LocalTime.now()));
        decoratedAsistenciaLaboral.asignarVacaciones(LocalDate.now(), LocalDate.now());
        decoratedAsistenciaLaboral.eliminarAsistencia(LocalDate.now());
        decoratedAsistenciaLaboral.eliminarAusencia(LocalDate.now());
    }
}
