package dev.ryan.controllers;

import dev.ryan.entities.Employee;
import dev.ryan.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public Employee CreateEmployee(@RequestBody Employee employee){
        return employeeService.registerNewEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> GetAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("employees/{id}")
    public Employee getEmployeeByEmployeeId(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/employees/{id}")
    public Employee replaceEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployeeById(id);
        return employeeService.replaceEmployee(employee);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployeeById(id);
        return ("Employee #" + id + "successfully deleted.");
    }

}
