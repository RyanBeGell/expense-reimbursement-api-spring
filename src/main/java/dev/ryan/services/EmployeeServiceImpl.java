package dev.ryan.services;

import dev.ryan.entities.Employee;
import dev.ryan.config.Role;
import dev.ryan.exceptions.ResourceNotFoundException;
import dev.ryan.repos.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Employee saveEmployee(Employee employee) {
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        return employeeRepo.save(employee);
    }

    @Override
    public void addRoleToUser(String username, Role role) {
        Employee employee = employeeRepo.findByUsername(username);
        employee.setRole(role);
        employeeRepo.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> possibleEmployee = employeeRepo.findById(id);

        if(possibleEmployee.isPresent()){
            return possibleEmployee.get();
        } else{
            throw new ResourceNotFoundException("Employee with id #" + id +"not found.");
        }
    }

    @Override
    public void deleteEmployeeById(long id) {
            // return true if deleted, otherwise exception would already be thrown if not found.
            employeeRepo.delete(getEmployeeById(id));
    }
}
