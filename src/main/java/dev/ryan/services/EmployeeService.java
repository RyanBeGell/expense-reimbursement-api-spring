package dev.ryan.services;

import dev.ryan.entities.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(long id);

    void deleteEmployeeById(long id);

}
