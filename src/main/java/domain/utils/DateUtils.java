package domain.utils;

import java.time.LocalDate;
import java.time.DayOfWeek;

public class DateUtils {
    public static Dias getDayOfWeek(LocalDate date) {
       if (date.getDayOfWeek() == DayOfWeek.MONDAY) {
           return Dias.Lunes;
       }
        if (date.getDayOfWeek() == DayOfWeek.TUESDAY) {
            return Dias.Martes;
        }
        if (date.getDayOfWeek() == DayOfWeek.WEDNESDAY) {
            return Dias.Miercoles;
        }
        if (date.getDayOfWeek() == DayOfWeek.THURSDAY) {
            return Dias.Jueves;
        }
        if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
            return Dias.Viernes;
        }
        if (date.getDayOfWeek() == DayOfWeek.SATURDAY) {
            return Dias.Sabado;
        }
        if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
            return Dias.Domingo;
        }
        return null;
    }
}
