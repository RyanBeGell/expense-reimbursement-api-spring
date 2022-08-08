package dev.ryan.services;

import dev.ryan.entities.Employee;
import dev.ryan.entities.Role;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    void addRoleToUser(String username, Role role);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(long id);

    void deleteEmployeeById(long id);

}
