package com.exam.services;
import com.exam.models.Emp_Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpManagerServiceImpl implements EmpManagerService {

    @Autowired
    private EmpManagerService empManagerService;

    @Override
    public List <Emp_Manager> findAll() {
        return empManagerService.findAll();
    }

    @Override
    public void saveEmpManager(Emp_Manager Emp_Manager) {
        this.empManagerService.saveEmpManager(Emp_Manager);
    }

    @Override
    public Emp_Manager getEmpManagerById(long id) {
        Optional< Emp_Manager > optional = Optional.ofNullable(empManagerService.getEmpManagerById(id));
        Emp_Manager Emp_Manager = null;
        if (optional.isPresent()) {
            Emp_Manager = optional.get();
        } else {
            throw new RuntimeException(" Emp_Manager not found for id :: " + id);
        }
        return Emp_Manager;
    }

    @Override
    public void deleteEmpManagerById(long id) {
        this.empManagerService.deleteEmpManagerById(id);
    }
}
