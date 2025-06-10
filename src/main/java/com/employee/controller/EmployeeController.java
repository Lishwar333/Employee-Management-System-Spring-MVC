package com.employee.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.employee.dao.EmployeeDAO;

import com.employee.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @RequestMapping("/")
    public ModelAndView viewHomePage() {
        List<Employee> list = employeeDAO.getAllEmployees();
        return new ModelAndView("index", "employeeList", list);
    }

    @RequestMapping("/add")
    public ModelAndView showAddForm() {
        return new ModelAndView("AddEmployee", "employee", new Employee());
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveEmployee(@ModelAttribute("employee") Employee employee) {
        try {
            employeeDAO.saveEmployee(employee);
            return new ModelAndView("redirect:/");
        } catch (Exception e) {
            return new ModelAndView("ErrorEmployee", "message", "Failed to save employee: " + e.getMessage());
        }
    }

    @RequestMapping("/edit")
    public ModelAndView showEditForm(@RequestParam int id) {
        try {
            Employee employee = employeeDAO.getEmployeeById(id);
            return new ModelAndView("EditEmployee", "employee", employee);
        } catch (Exception e) {
            return new ModelAndView("ErrorEmployee", "message", "Employee not found");
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView updateEmployee(@ModelAttribute("employee") Employee employee) {
        try {
            employeeDAO.updateEmployee(employee);
            return new ModelAndView("redirect:/");
        } catch (Exception e) {
            return new ModelAndView("ErrorEmployee", "message", "Update failed: " + e.getMessage());
        }
    }

    @RequestMapping("/delete")
    public ModelAndView deleteEmployee(@RequestParam int id) {
        try {
            employeeDAO.deleteEmployee(id);
            return new ModelAndView("redirect:/");
        } catch (Exception e) {
            return new ModelAndView("ErrorEmployee", "message", "Delete failed: " + e.getMessage());
        }
    }
    
    
}