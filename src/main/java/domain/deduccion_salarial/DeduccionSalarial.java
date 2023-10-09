package domain.deduccion_salarial;

import domain.asistencia.Asistencia;
import domain.asistencia.HorasExtra;
import domain.salario.Salario;
import domain.salario.SalarioHoraExtra;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeduccionSalarial {

    private Double salarioBruto;
    private Isss isss;
    private Afp afp;
    private Renta renta;
    private Double salarioLiquido;


    DeduccionSalarial(Salario salarioBase, Salario[] salariosExtras, Asistencia asistencia) {
        this.calcularDeduccion(salarioBase, salariosExtras, asistencia);
    }

    private Double calcularSalarioBruto(Salario salarioBase, Salario[] salariosExtras, Asistencia asistencia) {
        HorasExtra horasExtras = asistencia.calcularHorasExtras();
        SalarioHoraExtra salarioHoraExtra = new SalarioHoraExtra(salarioBase.getSalario(), horasExtras);
        Double totalSalarioExtra = 0.0;
        for (Salario salario: salariosExtras) {
           totalSalarioExtra += salario.getSalario();
        }
        return salarioHoraExtra.getSalario() + totalSalarioExtra + salarioBase.getSalario();
    }

    void calcularDeduccion(Salario salarioBase, Salario[] salarios, Asistencia asistencia) {
       salarioBruto = calcularSalarioBruto(salarioBase, salarios, asistencia);
       afp = new Afp(salarioBruto);
       isss = new Isss(salarioBruto);
       Double salarioPreRenta = salarioBruto - afp.getAfpEmpleado() - isss.getIsssEmpleado();
       renta = new Renta(salarioPreRenta);
       salarioLiquido = renta.getSalarioLiquido();
    }
}
