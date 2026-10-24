
package com.example.employee_manager.controller;

import com.example.employee_manager.model.Employee;
import com.example.employee_manager.service.EmployeeService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Home page
    @GetMapping("/")
    public String home() {
        return "redirect:/employees";
    }

    // Get all employees - display HTML page
    @GetMapping("/employees")
    public String listEmployees(
            @RequestParam(required = false) String keyword,
            Model model) {

        model.addAttribute(
                "employees",
                employeeService.searchEmployees(keyword));

        model.addAttribute("employee", new Employee());
        model.addAttribute("keyword", keyword);

        return "employees";
    }

    // Get employee by ID
    @GetMapping("/employees/{id}")
    @ResponseBody
    public ResponseEntity<Employee> getEmployeeById(
            @PathVariable Long id) {

        return employeeService.getEmployeeById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add a new employee
    @PostMapping("/employees")
    public String addEmployee(
            @ModelAttribute Employee employee) {

        employeeService.saveEmployee(employee);

        return "redirect:/employees";
    }

    // Delete employee by ID
    @DeleteMapping("/employees/{id}")
    @ResponseBody
    public ResponseEntity<Void> deleteEmployee(
            @PathVariable Long id) {

        if (employeeService.getEmployeeById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        employeeService.deleteEmployee(id);

        return ResponseEntity.noContent().build();
    }
}
