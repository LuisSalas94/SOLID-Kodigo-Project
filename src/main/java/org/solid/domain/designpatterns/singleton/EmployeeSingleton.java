package org.solid.domain.designpatterns.singleton;

import org.solid.domain.empleado.Empleado;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmployeeSingleton {

    private static EmployeeSingleton instance;
    private final List<Empleado> empleadoList;

    private EmployeeSingleton(){
        empleadoList = new ArrayList<>();
    }

    public static EmployeeSingleton getInstance(){
        if(instance == null){
            instance = new EmployeeSingleton();
        }
        return instance;
    }

    public Empleado getEmployee(String name, String surname){
        return empleadoList.stream().filter(e -> Objects.equals(e.getNombres(), name) && Objects.equals(e.getApellidos(), surname)).findFirst().orElse(null);
    }

    public Empleado getEmployeeByID(String id){
        return empleadoList.stream().filter(e -> Objects.equals(e.getIdenticicacion(),id)).findFirst().orElse(null);
    }
    public List<Empleado> getEmployeeList(){
        return empleadoList;
    }

    public Empleado createEmployee(Empleado employee){
        if(getEmployeeByID(employee.getIdenticicacion())!=null){
            System.out.println("Registered employee...");
            return null; //generar una excepcion...
        }
        empleadoList.add(employee);
        return employee;
    }

    public Empleado updateEmployee(Empleado employee) throws Exception {
        Empleado tmp = getEmployeeByID(employee.getIdenticicacion());
        if(tmp == null){//no existe, no puede se actualizado
            throw new Exception("There is not an employee: " + employee.getIdenticicacion());
        }
        tmp.setNombres(employee.getNombres());
        tmp.setApellidos(employee.getApellidos());
        tmp.setFechaNacimiento(employee.getFechaNacimiento());
        tmp.setDireccion(employee.getDireccion());
        tmp.setContacto(employee.getContacto());
        tmp.setFechaContrato(employee.getFechaContrato());
        return tmp;
    }

    public boolean deleteEmployee(String id){
       Empleado tmp = new Empleado();
        for (Empleado empleado : empleadoList) {
            if (Objects.equals(empleado.getIdenticicacion(), id)) {
                tmp = empleado;
                break;
            }
        }

        return empleadoList.remove(tmp); // Indica que se eliminó el empleado

    }

}
