package com.example.employee_management.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employees")  // This tells Spring Data MongoDB to use a collection named "employees"
public class Employee {

    @Id  // This marks the field as the unique identifier (primary key)
    private String id;
    private String name;
    private String position;
    private double salary;

    // Getters and setters (so Spring can access the properties)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
