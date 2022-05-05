package com.knoldus.employee_api.repos;

import com.knoldus.employee_api.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepos extends JpaRepository<Employee,Integer> {

}
