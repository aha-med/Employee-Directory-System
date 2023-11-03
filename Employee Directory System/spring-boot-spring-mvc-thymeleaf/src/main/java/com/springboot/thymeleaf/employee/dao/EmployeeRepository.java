package com.springboot.thymeleaf.employee.dao;

import com.springboot.thymeleaf.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

   public List<Employee> findAllByOrderByFirstNameAsc();

}
