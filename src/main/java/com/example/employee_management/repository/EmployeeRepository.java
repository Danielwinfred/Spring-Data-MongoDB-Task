package com.example.employee_management.repository;

import com.example.employee_management.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

// MongoRepository provides methods like save(), findAll(), findById(), etc.
public interface EmployeeRepository extends MongoRepository<Employee, String> {
}