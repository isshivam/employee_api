package com.knoldus.employee_api.controllers;

import com.knoldus.employee_api.entities.Employee;
import com.knoldus.employee_api.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/employees")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }
    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable Integer id){
        return employeeService.getEmployeeById(id);
    }
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable Integer id){
        employeeService.deleteEmployee(id);
    }
    @PostMapping("/employee")
    public Employee saveEmployee(@Valid @RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }
    @PostMapping("/employees")
    public List<Employee> saveEmployee(@Valid @RequestBody List<Employee> employees){
        return employeeService.saveMultipleEmployee(employees);
    }
    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

}
