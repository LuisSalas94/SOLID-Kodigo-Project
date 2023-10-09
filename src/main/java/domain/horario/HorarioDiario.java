package domain.horario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class HorarioDiario extends Horario {
    private LocalDateTime entrada;
    private LocalDateTime salida;

    public HorarioDiario(String nombre, String descripcion, LocalDateTime entrada, LocalDateTime salida) {
        super(nombre, descripcion);
        this.entrada = entrada;
        this.salida = salida;
    }
}
