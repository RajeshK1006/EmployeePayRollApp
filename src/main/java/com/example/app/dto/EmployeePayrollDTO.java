package com.example.app.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class EmployeePayrollDTO {

    @NotBlank(message = "Employee name cannot be null or empty")
    private String name;

    @Min(value = 500, message = "Salary should be more than 500")
    private long salary;

    // Constructors
    public EmployeePayrollDTO() {}

    public EmployeePayrollDTO(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }

    // Getters
    public String getName() {
        return name;
    }

    public long getSalary() {
        return salary;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeePayrollDTO [name=" + name + ", salary=" + salary + "]";
    }
}