package dev.ryan.controllers;

import dev.ryan.dtos.AddRoleToUserForm;
import dev.ryan.entities.Employee;
import dev.ryan.entities.Role;
import dev.ryan.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin("*")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/employees/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/employees")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Employee> GetAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("employees/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Employee getEmployeeByEmployeeId(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/employees/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public String deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployeeById(id);
        return ("Employee #" + id + "successfully deleted.");
    }

    @PostMapping("/role/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Role saveRole(@RequestBody Role role){
        return employeeService.saveRole(role);
    }

    @PostMapping("/role/addToUser")
    @ResponseStatus(code = HttpStatus.OK)
    public void addRoleToUser(@RequestBody AddRoleToUserForm form){
        employeeService.addRoleToUser(form.getUsername(), form.getRoleName());
    }

}
