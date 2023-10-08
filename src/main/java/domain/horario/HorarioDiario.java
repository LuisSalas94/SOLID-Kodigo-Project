package domain.horario;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class HorarioDiario extends Horario {

    @Getter
    @Setter
    private LocalDateTime entrada;

    @Getter
    @Setter
    private LocalDateTime salida;
}
