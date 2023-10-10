package org.solid.domain.asistencia;

import org.solid.domain.horario.HorarioDiario;
import org.solid.domain.horario.HorarioSemanal;
import org.solid.domain.utils.DateUtils;
import org.solid.domain.utils.Dias;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class HorasExtra {
        private LocalTime horaMaximaDiurna = LocalTime.of(19, 0);
        @Getter @Setter
        private int horasDiurnas = 0;
        @Getter @Setter
        private int horasNocturnas = 0;
        @Getter @Setter
        private AsistenciaLaboral asistencias;

        public HorasExtra(AsistenciaLaboral asistencias) {
                this.asistencias = asistencias;
                calcularHorasExtras();
        }

        public void calcularHorasExtras() {
                LocalDate fechaInicial = asistencias.getFechaInicio();
                LocalDate fechaFinal = asistencias.getFechaFinal();

                LocalDate fechaActual = fechaInicial;
                while (!fechaActual.isAfter(fechaFinal)) {
                       if(!asistencias.getAsistencias().containsKey(fechaActual)) {
                          fechaActual = fechaActual.plusDays(1);
                          continue;
                       }
                       Asistencia asistencia = asistencias.getAsistencias().get(fechaActual);
                       Dias dia = DateUtils.getDayOfWeek(fechaActual);
                       HorarioSemanal horarioSemanal = asistencias.getHorarioSemanal();
                       HorarioDiario horario = horarioSemanal.getHorario().get(dia);

                       LocalTime horaSalidaHorario = horario.getSalida();
                       LocalTime horaSalidaAsistencia = asistencia.getHoraSalida();

                       horasDiurnas += calcularHorasDiurnas(horaSalidaHorario, horaSalidaAsistencia);
                       horasNocturnas += calcularHorasNocturnas(horaSalidaHorario, horaSalidaAsistencia);
                       fechaActual = fechaActual.plusDays(1);
                }
        }

        private int calcularHorasDiurnas(LocalTime horaSalidaHorario, LocalTime horaSalidaAsistencia) {
                if (horaSalidaHorario.isAfter(horaSalidaAsistencia)) {
                        return 0;
                }
                if (horaSalidaHorario.isAfter(horaMaximaDiurna)) {
                        return 0;
                }
            return calcularTotalHoras(horaSalidaHorario, horaSalidaAsistencia);
        }

        private int calcularHorasNocturnas(LocalTime horaSalidaHorario, LocalTime horaSalidaAsistencia) {
            if (horaSalidaHorario.isAfter(horaSalidaAsistencia)) {
                return 0;
            }
            if (horaSalidaAsistencia.isBefore(horaMaximaDiurna)) {
                return 0;
            }
            return calcularTotalHoras(horaSalidaHorario, horaSalidaAsistencia);
        }

        private int calcularTotalHoras(LocalTime desde, LocalTime hasta) {
            Duration duracion = Duration.between(desde, hasta);
            int horaAdicional = 0;
            int totalHorasCompletas = (int) duracion.toHours();
            if ((duracion.toMinutes() % 60) > 5) {
               horaAdicional = 1;
            }

            return horaAdicional + totalHorasCompletas;
        }

}
