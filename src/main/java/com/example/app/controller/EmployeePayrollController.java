package com.example.app.controller;



import org.springframework.web.bind.annotation.*;
import java.util.Map;
import com.example.app.dto.EmployeePayrollDTO;
import com.example.app.model.EmployeePayrollData;
import jakarta.validation.Valid;


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

//    @PostMapping("/create")
//    public String createEmployee(@RequestBody Map<String, Object> employeeData) {
//        return "Created employee: " + employeeData;
//    }
    // updated 
    
    @PostMapping("/create")
    public EmployeePayrollData createEmployee(@Valid @RequestBody EmployeePayrollDTO empDTO) {
        return new EmployeePayrollData(empDTO.getName(), empDTO.getSalary());
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
