package com.exam.services;
import com.exam.models.Emp_Normal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpNormalServiceImpl implements EmpNormalService {

    @Autowired
    private EmpNormalService EmpNormalService;

    @Override
    public List <Emp_Normal> findAll() {
        return EmpNormalService.findAll();
    }

    @Override
    public void saveEmpNormal(Emp_Normal Emp_Normal) {
        this.EmpNormalService.saveEmpNormal(Emp_Normal);
    }

    @Override
    public Emp_Normal getEmpNormalById(long id) {
        Optional< Emp_Normal > optional = Optional.ofNullable(EmpNormalService.getEmpNormalById(id));
        Emp_Normal Emp_Normal = null;
        if (optional.isPresent()) {
            Emp_Normal = optional.get();
        } else {
            throw new RuntimeException(" Emp_Normal not found for id :: " + id);
        }
        return Emp_Normal;
    }

    @Override
    public void deleteEmpNormalById(long id) {
        this.EmpNormalService.deleteEmpNormalById(id);
    }
}
