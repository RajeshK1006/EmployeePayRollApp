package com.example.app.model;


public class EmployeePayrollData {
	private static int counter = 1;
    private int id;
    private String name;
    private long salary;

    // Constructors
    public EmployeePayrollData() {}

    public EmployeePayrollData(String name, long salary) {
        this.id = counter++;
        this.name = name;
        this.salary = salary;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getSalary() {
        return salary;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeePayrollData [id=" + id + ", name=" + name + ", salary=" + salary + "]";
    }
}

