package org.solid.domain.designpatterns.decorator;

import org.solid.domain.asistencia.Asistencia;
import org.solid.domain.asistencia.Ausencia;

import java.time.LocalDate;

// Decorator
public class AsistenciaLaboralDecorator implements AsistenciaLaboralComponent {
    private final AsistenciaLaboralComponent asistenciaLaboralComponent;

    public AsistenciaLaboralDecorator(AsistenciaLaboralComponent asistenciaLaboralComponent) {
        this.asistenciaLaboralComponent = asistenciaLaboralComponent;
    }

    @Override
    public void registrarAusencia(LocalDate fecha, Ausencia ausencia) {
        System.out.println("Decorating registrarAusencia method");
        asistenciaLaboralComponent.registrarAusencia(fecha, ausencia);
    }

    @Override
    public void registrarAsistencia(LocalDate fecha, Asistencia asistencia) {
        System.out.println("Decorating registrarAsistencia method");
        asistenciaLaboralComponent.registrarAsistencia(fecha, asistencia);
    }

    @Override
    public void asignarVacaciones(LocalDate fechaInicio, LocalDate fechaFinal) {
        System.out.println("Decorating asignarVacaciones method");
        asistenciaLaboralComponent.asignarVacaciones(fechaInicio, fechaFinal);
    }

    @Override
    public void eliminarAsistencia(LocalDate fecha) {
        System.out.println("Decorating eliminarAsistencia method");
        asistenciaLaboralComponent.eliminarAsistencia(fecha);
    }

    @Override
    public void eliminarAusencia(LocalDate fecha) {
        System.out.println("Decorating eliminarAusencia method");
        asistenciaLaboralComponent.eliminarAusencia(fecha);
    }
}

