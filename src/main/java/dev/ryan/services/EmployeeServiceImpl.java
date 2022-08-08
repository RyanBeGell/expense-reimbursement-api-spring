package dev.ryan.services;

import dev.ryan.entities.Employee;
import dev.ryan.entities.Role;
import dev.ryan.exceptions.ResourceNotFoundException;
import dev.ryan.repos.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepo employeeRepo;

    @Override
    public Employee saveEmployee(Employee employee) {
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
