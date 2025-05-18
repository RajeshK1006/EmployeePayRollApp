
package com.example.app.service;

import com.example.app.dto.EmployeePayrollDTO;
import com.example.app.model.EmployeePayrollData;
import java.util.List;

public interface EmployeePayrollService {
    List<EmployeePayrollData> getAllEmployees();
    EmployeePayrollData getEmployeeById(int id);
    EmployeePayrollData createEmployee(EmployeePayrollDTO empDTO);
    EmployeePayrollData updateEmployee(int id, EmployeePayrollDTO empDTO);
    void deleteEmployee(int id);
}
