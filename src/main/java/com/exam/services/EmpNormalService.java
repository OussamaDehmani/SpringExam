package com.exam.services;
import com.exam.models.Emp_Manager;
import com.exam.models.Emp_Normal;

import java.util.List;


public interface EmpNormalService {


    void saveEmpNormal(Emp_Normal emp_normal);
    Emp_Normal getEmpNormalById(long id);
    void deleteEmpNormalById(long id);

    List<Emp_Normal> findAll();
}
