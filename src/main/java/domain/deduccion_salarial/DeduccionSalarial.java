package domain.deduccion_salarial;

import domain.salario.Salario;

class HorasExtras {

}

class Asistencia {
   HorasExtras calcularHorasExtras() {
       return new HorasExtras();
   }
}

public class DeduccionSalarial {
    private Double salarioBruto;
    private Isss isss;
    private Afp afp;
    private Double salarioLiquido;

    private

    DeduccionSalarial(Salario[] salarios, Asistencia asistencia) {

    }

    private Double calcularSalarioBruto(Salario[] salarios, Asistencia) {

    }

    void calcularDeduccion(Salario[] salarios, Asistencia asistencia) {
       this.salarioBruto = calcularSalarioBruto(salarios, asistencia);
    }
}
