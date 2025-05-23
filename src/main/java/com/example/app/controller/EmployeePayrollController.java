package com.example.app.controller;

import com.example.app.dto.EmployeePayrollDTO;
import com.example.app.model.EmployeePayrollData;
import com.example.app.service.EmployeePayrollService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
@Slf4j
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService employeeService;

    @GetMapping("/")
    public List<EmployeePayrollData> getAllEmployees() {
        log.info("Fetching all employee payroll data");
        return employeeService.getAllEmployees();
    }

    @GetMapping("/get/{id}")
    public EmployeePayrollData getEmployee(@PathVariable("id") int id) {
        log.info("Fetching employee payroll data for ID: {}", id);
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/create")
    public EmployeePayrollData createEmployee(@Valid @RequestBody EmployeePayrollDTO empDTO) {
        log.info("Creating new employee payroll entry: {}", empDTO);
        return employeeService.createEmployee(empDTO);
    }

    @PutMapping("/update/{id}")
    public EmployeePayrollData updateEmployee(@PathVariable("id") int id,
                                              @Valid @RequestBody EmployeePayrollDTO empDTO) {
        log.info("Updating employee with ID: {} with data: {}", id, empDTO);
        return employeeService.updateEmployee(id, empDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        log.info("Deleting employee with ID: {}", id);
        employeeService.deleteEmployee(id);
        return "Deleted employee with ID: " + id;
    }
}
