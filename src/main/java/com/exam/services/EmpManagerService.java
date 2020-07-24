package com.exam.services;
import com.exam.models.Departement;
import com.exam.models.Emp_Manager;

import java.util.List;


public interface EmpManagerService {


    void saveEmpManager(Emp_Manager emp_Manager);
    Emp_Manager getEmpManagerById(long id);
    void deleteEmpManagerById(long id);

    List<Emp_Manager> findAll();
}
