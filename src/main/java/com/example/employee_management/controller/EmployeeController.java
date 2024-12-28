package com.example.employee_management.controller;

import com.example.employee_management.model.Employee;
import com.example.employee_management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController  // This tells Spring that this class will handle HTTP requests
@RequestMapping("/api/employees")  // This defines the base URL for all API endpoints related to employees
public class EmployeeController {

    @Autowired  // This automatically injects the EmployeeRepository instance
    private EmployeeRepository employeeRepository;

    // Create a new employee (via POST request)
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);  // Save the employee in the MongoDB database
    }

    // Get all employees (via GET request)
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();  // Retrieve all employees from the database
    }

    // Get a specific employee by ID (via GET request)
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String id) {
        Optional<Employee> employee = employeeRepository.findById(id);  // Find the employee by ID
        return employee.map(ResponseEntity::ok)  // If the employee is found, return it with a 200 OK response
                .orElseGet(() -> ResponseEntity.notFound().build());  // If not, return a 404 Not Found
    }
}
