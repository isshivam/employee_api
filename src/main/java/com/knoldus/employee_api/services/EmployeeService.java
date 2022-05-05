package com.knoldus.employee_api.services;


import com.knoldus.employee_api.entities.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();
    Employee getEmployeeById(Integer id);
    void deleteEmployee(Integer id);
    Employee saveEmployee(Employee employee);
    List<Employee> saveMultipleEmployee(List<Employee> employees);
    Employee updateEmployee(Employee employee);
}
