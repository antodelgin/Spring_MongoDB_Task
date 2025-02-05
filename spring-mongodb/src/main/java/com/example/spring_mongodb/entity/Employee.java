package com.example.spring_mongodb.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


//  Employee entity class representing an employee document in MongoDB.

@Data
@Document(collection = "employees")
public class Employee {

    private String id;
    private String name;
    private String email;
    private String location;

}
