package com.employee.dao;

import java.util.List;

import com.employee.model.Employee;

public interface EmployeeDAO {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    void saveEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);
}