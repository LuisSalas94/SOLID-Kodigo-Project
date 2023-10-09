package domain.horario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
abstract public class Horario {
    private String nombre;
    private String descripcion;
}
