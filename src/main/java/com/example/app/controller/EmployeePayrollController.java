// EmployeePayrollController.java
package com.example.app.controller;

import com.example.app.dto.EmployeePayrollDTO;
import com.example.app.model.EmployeePayrollData;
import com.example.app.service.EmployeePayrollService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService employeeService;

    @GetMapping("/")
    public List<EmployeePayrollData> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/get/{id}")
    public EmployeePayrollData getEmployee(@PathVariable("id") int id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/create")
    public EmployeePayrollData createEmployee(@Valid @RequestBody EmployeePayrollDTO empDTO) {
        return employeeService.createEmployee(empDTO);
    }

    @PutMapping("/update/{id}")
    public EmployeePayrollData updateEmployee(@PathVariable("id") int id,
                                              @Valid @RequestBody EmployeePayrollDTO empDTO) {
        return employeeService.updateEmployee(id, empDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
        return "Deleted employee with ID: " + id;
    }
}
