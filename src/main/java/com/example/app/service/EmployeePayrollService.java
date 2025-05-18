package com.example.app.service;

import com.example.app.dto.EmployeePayrollDTO;
import com.example.app.model.EmployeePayrollData;

public interface EmployeePayrollService {
    String getAllEmployees();
    String getEmployeeById(int id);
    EmployeePayrollData createEmployee(EmployeePayrollDTO empDTO);
    String updateEmployee(Object employeeData);
    String deleteEmployee(int id);
}
