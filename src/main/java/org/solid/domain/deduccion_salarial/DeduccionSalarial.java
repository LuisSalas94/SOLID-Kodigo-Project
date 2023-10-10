package org.solid.domain.deduccion_salarial;

import lombok.Getter;
import lombok.Setter;
import org.solid.domain.asistencia.HorasExtra;
import org.solid.domain.salario.Salario;
import org.solid.domain.salario.SalarioHoraExtra;

@Getter
@Setter
public class DeduccionSalarial {

  private Double salarioBruto;
  private Isss isss;
  private Afp afp;
  private Renta renta;
  private Double salarioLiquido;
  private HorasExtra horasExtras;

  public DeduccionSalarial(Salario salarioBase, Salario[] salariosExtras, HorasExtra horasExtras) {
    this.horasExtras = horasExtras;
    this.calcularDeduccion(salarioBase, salariosExtras);
  }

  public DeduccionSalarial(Salario salarioBase, HorasExtra horasExtras) {
    this.horasExtras = horasExtras;
    this.calcularDeduccion(salarioBase, new Salario[] {});
  }

  private Double calcularSalarioBruto(Salario salarioBase, Salario[] salariosExtras) {
    SalarioHoraExtra salarioHoraExtra =
        new SalarioHoraExtra(salarioBase.getSalarioBaseMensual(), horasExtras);
    Double totalSalarioExtra = 0.0;
    for (Salario salario : salariosExtras) {
      totalSalarioExtra += salario.getSalario();
    }
    return salarioHoraExtra.getSalario() + totalSalarioExtra + salarioBase.getSalario();
  }

  void calcularDeduccion(Salario salarioBase, Salario[] salarios) {
    salarioBruto = calcularSalarioBruto(salarioBase, salarios);
    afp = new Afp(salarioBruto);
    isss = new Isss(salarioBruto);
    Double salarioPreRenta = salarioBruto - afp.getAfpEmpleado() - isss.getIsssEmpleado();
    renta = new Renta(salarioPreRenta);
    salarioLiquido = renta.getSalarioLiquido();
  }
}
