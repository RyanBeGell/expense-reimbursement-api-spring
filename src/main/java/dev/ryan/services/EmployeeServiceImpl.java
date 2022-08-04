package dev.ryan.services;

import dev.ryan.entities.Employee;
import dev.ryan.entities.Role;
import dev.ryan.repos.EmployeeRepo;
import dev.ryan.repos.RoleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepo employeeRepo;
    private final RoleRepo roleRepo;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        Employee employee = employeeRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        employee.getRoles().add(role);
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
            throw new EntityNotFoundException("Employee with id #" + id +"not found.");
        }
    }

    @Override
    public void deleteEmployeeById(long id) {
            // return true if deleted, otherwise exception would already be thrown if not found.
            employeeRepo.delete(getEmployeeById(id));
    }
}
