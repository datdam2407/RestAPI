package com.datdt.RestAPI.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbl_employee")
public class Employee implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private long employeeID;
    //First name and lastname of Employee not be null have at least 2 character
    @NotEmpty
    @Size(min = 2,max = 30, message = "First name have at least 2 characters")
    @Column(name = "employee_firstname")
    private String employeeFirstname;
    @NotEmpty
    @Size(min = 2,max = 30, message = "Last name have at least 2 characters")
    @Column(name = "employee_lastname")
    private String employeeLastname;
    @NotEmpty
    @Size(min = 1,max = 150, message = "Address must be filled")
    @Column(name = "employee_address")
    private String employeeAdress;
    @NotEmpty
    @Size(max = 10, message = "phone have at least 10 number")
    @Column(name = "employee_phone")
    private String employeePhone;
    
    
    public Employee() {
        super();
    }
    public Employee(String employeeFirstname, String employeeLastname, String employeeAdress, String employeePhone) {
        super();
        this.employeeFirstname = employeeFirstname;
        this.employeeLastname = employeeLastname;
        this.employeeAdress = employeeAdress;
        this.employeePhone = employeePhone;
    }
    public long getEmployeeID() {
        return employeeID;
    }
    public void setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
    }
    public String getEmployeeFirstname() {
        return employeeFirstname;
    }
    public void setEmployeeFirstname(String employeeFirstname) {
        this.employeeFirstname = employeeFirstname;
    }
    public String getEmployeeLastname() {
        return employeeLastname;
    }
    public void setEmployeeLastname(String employeeLastname) {
        this.employeeLastname = employeeLastname;
    }
    public String getEmployeeAdress() {
        return employeeAdress;
    }
    public void setEmployeeAdress(String employeeAdress) {
        this.employeeAdress = employeeAdress;
    }
    public String getEmployeePhone() {
        return employeePhone;
    }
    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }
    
}