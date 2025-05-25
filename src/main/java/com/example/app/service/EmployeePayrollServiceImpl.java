package com.example.app.service;

import com.example.app.dto.EmployeePayrollDTO;
import com.example.app.exception.EmployeeNotFoundException;
import com.example.app.model.EmployeePayrollData;
import com.example.app.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeePayrollServiceImpl implements EmployeePayrollService {

    private final EmployeeRepository repo;

    public EmployeePayrollServiceImpl(EmployeeRepository repo){
        this.repo = repo;
    }

    @Override
    public List<EmployeePayrollData> getAllEmployees() {
        return repo.findAll();
    }

    @Override
    public EmployeePayrollData getEmployeeById(int id) {
        return repo.findById(id).orElseThrow(()-> new EmployeeNotFoundException("Employee not found with id: " + id));
    }

    @Override
    public EmployeePayrollData createEmployee(EmployeePayrollDTO empDTO) {
        EmployeePayrollData newEmployee = new EmployeePayrollData(empDTO.getName(), empDTO.getSalary());
        repo.save(newEmployee);
        return newEmployee;
    }

    @Override
    public EmployeePayrollData updateEmployee(int id, EmployeePayrollDTO empDTO) {
        Optional<EmployeePayrollData> optionalEmployee = repo.findById(id);
        if(optionalEmployee.isEmpty()){
            throw new EmployeeNotFoundException("Employee not found with id: " + id);
        }
        else{
            EmployeePayrollData employee = optionalEmployee.get();
            employee.setName(empDTO.getName());
            employee.setSalary(empDTO.getSalary());
            return employee;
        }

    }

    @Override
    public void deleteEmployee(int id) {
        if(!repo.existsById(id)){
            throw new EmployeeNotFoundException("Employee not found with id: " + id);
        }
        repo.deleteById(id);git
    }
}
