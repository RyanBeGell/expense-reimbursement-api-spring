package dev.ryan.services;

import dev.ryan.entities.Employee;
import java.util.List;

public interface EmployeeService {

    Employee registerNewEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(int ID);

    Employee replaceEmployee(Employee employee);

    void deleteEmployeeById(int id);

}
