package com.exam.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue(value = "Emp_Manager")
public class Emp_Manager extends Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long  id;

    @OneToMany
    private List<Employee> subordinates;

    public List<Employee> getNormalEmployees() {
        return this.subordinates;
    }

    public void setSousAdjacents(List<Employee> employeeList){
        this.subordinates=employeeList;
    }

}
