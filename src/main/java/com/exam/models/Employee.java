package com.exam.models;
import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "name")
    private String firstName;

    @Column(name = "email")
    private String email;

    @Column(name = "grad_comp")
    private String grad_comp;

    @Column(name="created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Column(name="modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;


    @ManyToOne(fetch= FetchType.EAGER)
    Departement departement;

    @ManyToOne(fetch= FetchType.EAGER)
    Remuneration remuneration;

    @ManyToOne(fetch= FetchType.EAGER)
    User user;


    public String type() {
        Class<?> employeeClass = this.getClass();
        if(employeeClass.getName() == "com.exam.models.Emp_Manager"){
            return "manager";
        }else if (employeeClass.getName() == "com.exam.models.Emp_Normal"){
            return "normal";
        }else{
            return "erreur";
        }
    }
}