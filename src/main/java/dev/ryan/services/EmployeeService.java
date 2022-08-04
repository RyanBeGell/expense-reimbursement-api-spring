package dev.ryan.services;

import dev.ryan.entities.Employee;
import dev.ryan.entities.Role;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(long id);

    void deleteEmployeeById(long id);

}
