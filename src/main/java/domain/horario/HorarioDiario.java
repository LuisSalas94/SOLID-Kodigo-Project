package domain.horario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
public class HorarioDiario extends Horario {
    private LocalTime entrada;
    private LocalTime salida;

    public HorarioDiario(String nombre, String descripcion, LocalTime entrada, LocalTime salida) {
        super(nombre, descripcion);
        this.entrada = entrada;
        this.salida = salida;
    }
}
