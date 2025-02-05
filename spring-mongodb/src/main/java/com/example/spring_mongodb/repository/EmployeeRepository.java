package com.example.spring_mongodb.repository;

import com.example.spring_mongodb.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

//  Repository interface for Employee entity.
//  Provides CRUD operations on the Employee collection.

public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
