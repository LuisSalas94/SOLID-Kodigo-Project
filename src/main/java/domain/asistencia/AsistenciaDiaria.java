package domain.asistencia;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AsistenciaDiaria extends Asistencia {
    private AsistenciaHorario asistencia;
    private Ausencia ausencia;

    @Override
    public HorasExtra calcularHorasExtras() {
        return new HorasExtra();
    }
}
