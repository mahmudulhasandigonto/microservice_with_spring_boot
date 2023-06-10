package com.example.departmentservice.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
    //@OneToMany(fetch = FetchType.EAGER)
   // @JoinColumn(name="employees_id", nullable = false)
   // private List<Employee> employees = new ArrayList<>();

}
