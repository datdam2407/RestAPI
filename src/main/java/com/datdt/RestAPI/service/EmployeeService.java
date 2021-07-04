package com.datdt.RestAPI.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.datdt.RestAPI.entity.Employee;
import com.datdt.RestAPI.exception.EmployeeException;
import com.datdt.RestAPI.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // List Employee
    public List<Employee> getAllEmployees() {
        return this.employeeRepository.findAll();
    }

    // get employee by ID
    public ResponseEntity<Employee> getEmployeeByID(Long employeeID) throws EmployeeException {
        Employee employee = employeeRepository.findById(employeeID)
                .orElseThrow(() -> new EmployeeException(employeeID));
        return ResponseEntity.ok().body(employee);
    }
    // create new employee

    public Employee createEmployee(Employee newemployee) {
        return this.employeeRepository.save(newemployee);
    }

    // update Employee
    public ResponseEntity<Employee> updateEmployee(Long employeeID, Employee employeeDetail) {
        Employee employee = employeeRepository.findById(employeeID)
                .orElseThrow(() -> new EmployeeException(employeeID));
        employee.setEmployeeFirstname(employeeDetail.getEmployeeFirstname());
        employee.setEmployeeLastname(employeeDetail.getEmployeeLastname());
        employee.setEmployeeAdress(employeeDetail.getEmployeeAdress());
        employee.setEmployeePhone(employeeDetail.getEmployeePhone());
        return ResponseEntity.ok(this.employeeRepository.save(employee));
    }

    // Delete Employee
    public Map<String, Boolean> deleteEmployee(Long employeeID) {
        Employee employee = employeeRepository.findById(employeeID)
                .orElseThrow(() -> new EmployeeException(employeeID));
        this.employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("DELETED", Boolean.TRUE);
        return response;
    }

}
