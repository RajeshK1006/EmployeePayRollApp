package com.example.app.controller;



import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @GetMapping("/")
    public String getAllEmployees() {
        return "Get all employee payroll data";
    }

    @GetMapping("/get/{id}")
    public String getEmployee(@PathVariable("id") int id) {
        return "Get employee data for ID: " + id;
    }

    @PostMapping("/create")
    public String createEmployee(@RequestBody Map<String, Object> employeeData) {
        return "Created employee: " + employeeData;
    }

    @PutMapping("/update")
    public String updateEmployee(@RequestBody Map<String, Object> employeeData) {
        return "Updated employee: " + employeeData;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        return "Deleted employee with ID: " + id;
    }
}
