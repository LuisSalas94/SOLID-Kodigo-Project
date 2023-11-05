package org.solid.demo;

import java.time.LocalDate;
import java.time.LocalTime;

import org.solid.domain.asistencia.Asistencia;
import org.solid.domain.asistencia.AsistenciaLaboral;
import org.solid.domain.asistencia.HorasExtra;
import org.solid.domain.deduccion_salarial.DeduccionSalarial;
import org.solid.domain.deduccion_salarial.NominaSalarial;
import org.solid.domain.designpatterns.EmployeeSingleton;
import org.solid.domain.designpatterns.builder.EmployeeBuilder;
import org.solid.domain.designpatterns.decorator.AsistenciaLaboralComponent;
import org.solid.domain.designpatterns.decorator.AsistenciaLaboralDecorator;
import org.solid.domain.designpatterns.observer.AttendanceObserver;
import org.solid.domain.designpatterns.observer.Observer;
import org.solid.domain.empleado.Empleado;
import org.solid.domain.horario.HorarioDiario;
import org.solid.domain.horario.HorarioSemanal;
import org.solid.domain.salario.Salario;
import org.solid.domain.designpatterns.factory.SalarioFactory;
import org.solid.domain.utils.Dias;

public class Demo {

    public static void main(String[] args) {

        // Fake Empleado
        Empleado empleado = new EmployeeBuilder("Juan", "Pérez", LocalDate.of(1990, 5, 15))
                .identification("234252-2")
                .build();

        //Fake database
        EmployeeSingleton.getInstance().createEmployee(empleado);


        // Fake Horarios
        HorarioSemanal horarioTecnicoSemanal =
                new HorarioSemanal("Horario tecnico", "Horario de los tecnicos en mantenimiento");
        HorarioDiario horarioMantenimiento =
                new HorarioDiario(
                        "Mantenimiento",
                        "Horario de mantenimiento de equipos",
                        LocalTime.of(7, 0),
                        LocalTime.of(12, 0));
        horarioTecnicoSemanal.agregarOSustituirHorario(Dias.Lunes, horarioMantenimiento);

        // Fake Asistencias
        Asistencia asistencia = new Asistencia(LocalTime.of(7, 0), LocalTime.of(4, 0));
        AsistenciaLaboral asistenciaLaboral =
                new AsistenciaLaboral(
                        horarioTecnicoSemanal, LocalDate.of(2023, 10, 1), LocalDate.of(2023, 10, 31));
        asistenciaLaboral.registrarAsistencia(LocalDate.of(2023, 10, 9), asistencia);

        Observer attendanceObserver = new AttendanceObserver();

        asistenciaLaboral.addObserver(attendanceObserver);

        AsistenciaLaboralComponent decoratedAsistenciaLaboral = new AsistenciaLaboralDecorator(asistenciaLaboral);
        decoratedAsistenciaLaboral.registrarAsistencia(LocalDate.of(2023, 10, 10), new Asistencia(LocalTime.of(8, 0), LocalTime.of(16, 0)));
        decoratedAsistenciaLaboral.asignarVacaciones(LocalDate.of(2023, 10, 15), LocalDate.of(2023, 10, 20));
        decoratedAsistenciaLaboral.eliminarAsistencia(LocalDate.of(2023, 10, 10));
        decoratedAsistenciaLaboral.eliminarAusencia(LocalDate.of(2023, 10, 10));


        // Fake Salarios
        Salario salario = SalarioFactory.crearSalario(1200.00, "SalarioMensual");
        HorasExtra horasExtras = new HorasExtra(asistenciaLaboral);

        // Fake Nomina
        NominaSalarial nomina = new NominaSalarial();
        nomina.setAsistenciaLaboral(asistenciaLaboral);
        nomina.setEmpleado(empleado);
        nomina.setVigencia("From yesterday");
        nomina.setDeduccionSalarial(new DeduccionSalarial(salario, horasExtras));

        // Resultados
        System.out.println(
                "Empleado: "
                        + nomina.getEmpleado().getNombres()
                        + " "
                        + nomina.getEmpleado().getApellidos());
        System.out.println("Salario bruto: " + nomina.getDeduccionSalarial().getSalarioBruto());
        System.out.println("Afp: " + nomina.getDeduccionSalarial().getAfp().getAfpEmpleado());
        System.out.println("Isss: " + nomina.getDeduccionSalarial().getIsss().getIsssEmpleado());
        System.out.println("Renta: " + nomina.getDeduccionSalarial().getRenta().getRetencion());
        System.out.println("Salario líquido: " + nomina.getDeduccionSalarial().getSalarioLiquido());
    }
}
