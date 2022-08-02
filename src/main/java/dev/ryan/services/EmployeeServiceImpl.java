package dev.ryan.services;

import dev.ryan.entities.Employee;
import dev.ryan.repos.EmployeeRepo;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepo employeeRepo;

    @Override
    public Employee registerNewEmployee(Employee employee) {
        return this.employeeRepo.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return this.employeeRepo.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        Optional<Employee> possibleEmployee = this.employeeRepo.findById(id);

        if(possibleEmployee.isPresent()){
            return possibleEmployee.get();
        } else{
            throw new EntityNotFoundException("Employee with id #" + id +"not found.");
        }
    }

    @Override
    public Employee replaceEmployee(Employee employee) {
       return employeeRepo.save(employee);
    }

    @Override
    public void deleteEmployeeById(int id) {
            // return true if deleted, otherwise exception would already be thrown if not found.
            employeeRepo.delete(this.getEmployeeById(id));
    }
}
