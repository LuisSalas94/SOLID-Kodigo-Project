package org.solid.domain.designpatterns.builder;

import lombok.Getter;
import lombok.Setter;
import org.solid.domain.empleado.Empleado;

import java.time.LocalDate;

public class EmployeeBuilder {
    private String name;
    private String surname;

    private LocalDate birthDate;

    private String address;

    private String identification;

    private String contact;
    private LocalDate contractDate;

    public EmployeeBuilder(String name, String surname, LocalDate birthDate){
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public EmployeeBuilder address(String address){
        this.address = address;
        return this;
    }
    public EmployeeBuilder identification(String identification){
        this.identification = identification;
        return this;

    }
    public EmployeeBuilder contact(String contact){
        this.contact = contact;
        return this;

    }
    public EmployeeBuilder contractDate(LocalDate contractDate){
        this.contractDate = contractDate;
        return this;
    }
    public Empleado build(){
        return new Empleado(name, surname, birthDate, address, identification, contact, contractDate);
    }
}
