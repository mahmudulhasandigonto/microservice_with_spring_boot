package com.example.departmentservice.model;


import jakarta.persistence.Entity;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department extends BaseEntity{

    private String name;
   // private List<Employee> employees = new ArrayList<>();

}
