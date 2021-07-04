package com.datdt.RestAPI.repository;


import com.datdt.RestAPI.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
  
}
