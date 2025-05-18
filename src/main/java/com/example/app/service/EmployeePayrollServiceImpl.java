package com.example.app.service;



import org.springframework.stereotype.Service;
import com.example.app.dto.EmployeePayrollDTO;
import com.example.app.model.EmployeePayrollData;

@Service
public class EmployeePayrollServiceImpl implements EmployeePayrollService {

    @Override
    public String getAllEmployees() {
        return "Get all employee payroll data";
    }

    @Override
    public String getEmployeeById(int id) {
        return "Get employee data for ID: " + id;
    }

    @Override
    public EmployeePayrollData createEmployee(EmployeePayrollDTO empDTO) {
        return new EmployeePayrollData(empDTO.getName(), empDTO.getSalary());
    }

    @Override
    public String updateEmployee(Object employeeData) {
        return "Updated employee: " + employeeData;
    }

    @Override
    public String deleteEmployee(int id) {
        return "Deleted employee with ID: " + id;
    }
}
