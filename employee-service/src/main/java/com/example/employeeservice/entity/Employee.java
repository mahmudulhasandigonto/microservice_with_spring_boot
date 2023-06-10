package com.example.employeeservice.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends BaseEntity{
    private Long departmentId;
    private String name;
    private int age;
   private String position;
}
