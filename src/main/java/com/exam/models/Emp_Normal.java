package com.exam.models;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Emp_Normal extends Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long  id;
    @ManyToOne(fetch= FetchType.EAGER)
    private Emp_Manager emp_manager;


    public Emp_Manager getManager() {
        return this.emp_manager;
    }

}
