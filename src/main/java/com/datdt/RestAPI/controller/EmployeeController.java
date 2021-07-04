package com.datdt.RestAPI.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.datdt.RestAPI.entity.Employee;
import com.datdt.RestAPI.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
        public EmployeeController(EmployeeService employeeService) {
            this.employeeService = employeeService;
        }
    //List employees
    @GetMapping("/employees")
        public List<Employee> getAllEmployees(){
            return (List<Employee>) employeeService.getAllEmployees(); 
        }
    //get employee by ID
    @GetMapping("/employees/{id}")
        public ResponseEntity<Employee> getEmployeeByID(@PathVariable(value = "id") Long employeeID){
            return employeeService.getEmployeeByID(employeeID);
        }
    // create employee
    @PostMapping("/employees")
        public Employee createEmployee(@Valid @RequestBody Employee newEmployee){
            return employeeService.createEmployee(newEmployee);
        }
    //update employee
    @PutMapping("/employees/{id}")
        public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeID,@Valid  @RequestBody Employee employeeDetail){
            return employeeService.updateEmployee(employeeID, employeeDetail);
        }
    //Delete employee
    @DeleteMapping("/employees/{id}")
        public Map<String, Boolean> deteleEmployee(@PathVariable(value = "id") Long employeeID){
            return employeeService.deleteEmployee(employeeID);
        }
}

