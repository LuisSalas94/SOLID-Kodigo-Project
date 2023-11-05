package org.solid.domain.deduccion_salarial;

import lombok.Getter;
import lombok.Setter;
import org.solid.domain.asistencia.HorasExtra;
import org.solid.domain.designpatterns.strategy.IDeduccion;
import org.solid.domain.designpatterns.strategy.ISalarioBruto;
import org.solid.domain.salario.Salario;
import org.solid.domain.salario.SalarioHoraExtra;

@Getter
@Setter
public class DeduccionSalarial implements IDeduccion, ISalarioBruto {

  private Double salarioBruto;
  private Isss isss;
  private Afp afp;
  private Renta renta;
  private Double salarioLiquido;
  private HorasExtra horasExtras;

  private Salario salarioBase;
  private Salario[] salariosExtras;

  public DeduccionSalarial(Salario salarioBase, Salario[] salariosExtras, HorasExtra horasExtras) {
    this.horasExtras = horasExtras;
    this.salarioBase = salarioBase;
    this.salariosExtras = salariosExtras;
  }

  public DeduccionSalarial(Salario salarioBase, HorasExtra horasExtras) {
    this.horasExtras = horasExtras;
    this.salarioBase = salarioBase;
    this.salariosExtras = new Salario[] {};
    calcularDeduccion();
  }

  @Override
  public void calcularSalarioBruto() {
    SalarioHoraExtra salarioHoraExtra =
        new SalarioHoraExtra(salarioBase.getSalarioBaseMensual(), horasExtras);
    Double totalSalarioExtra = 0.0;
    for (Salario salario : salariosExtras) {
      totalSalarioExtra += salario.getSalario();
    }
    this.salarioBruto = salarioHoraExtra.getSalario() + totalSalarioExtra + salarioBase.getSalario();
  }
@Override
  public void calcularDeduccion() {
    calcularSalarioBruto();
    afp = new Afp(salarioBruto);
    isss = new Isss(salarioBruto);
    Double salarioPreRenta = salarioBruto - afp.getAfpEmpleado() - isss.getIsssEmpleado();
    renta = new Renta(salarioPreRenta);
    salarioLiquido = renta.getSalarioLiquido();
  }
}
