package com.knoldus.employee_api.services;

import com.knoldus.employee_api.entities.Employee;
import com.knoldus.employee_api.exception.ResourceNotFoundException;
import com.knoldus.employee_api.repos.EmployeeRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepos employeeRepos;
    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepos.findAll();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        Optional<Employee> employee = employeeRepos.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }else{
            throw new ResourceNotFoundException("Expense is not found for the id "+id);
        }
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRepos.deleteById(id);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepos.save(employee);
    }

    @Override
    public List<Employee> saveMultipleEmployee(List<Employee> employees) {
        return employeeRepos.saveAll(employees);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Employee existingEmployee = getEmployeeById(employee.getId());
        existingEmployee.setName(employee.getName() != null ? employee.getName() : existingEmployee.getName());
        existingEmployee.setPassword(employee.getPassword() != null ? employee.getPassword() : existingEmployee.getPassword());
        return employeeRepos.save(existingEmployee);
    }
}
