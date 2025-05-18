
package com.example.app.service;

import com.example.app.dto.EmployeePayrollDTO;
import com.example.app.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollServiceImpl implements EmployeePayrollService {

    private final List<EmployeePayrollData> employeeList = new ArrayList<>();
    

    @Override
    public List<EmployeePayrollData> getAllEmployees() {
        return employeeList;
    }

    @Override
    public EmployeePayrollData getEmployeeById(int id) {
        return employeeList.stream()
                .filter(emp -> emp.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public EmployeePayrollData createEmployee(EmployeePayrollDTO empDTO) {
        EmployeePayrollData newEmployee = new EmployeePayrollData(empDTO.getName(), empDTO.getSalary());
        employeeList.add(newEmployee);
        return newEmployee;
    }

    @Override
    public EmployeePayrollData updateEmployee(int id, EmployeePayrollDTO empDTO) {
        EmployeePayrollData employee = getEmployeeById(id);
        if (employee != null) {
            employee.setName(empDTO.getName());
            employee.setSalary(empDTO.getSalary());
        }
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        employeeList.removeIf(emp -> emp.getId() == id);
    }
}
