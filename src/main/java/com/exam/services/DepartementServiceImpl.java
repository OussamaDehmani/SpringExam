package com.exam.services;
import com.exam.models.Departement;
import com.exam.models.Employee;
import com.exam.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartementServiceImpl implements DepartementService {

    @Autowired
    private DepartementService departementService;

    @Override
    public List <Departement> findAll() {
        return departementService.findAll();
    }

    @Override
    public void saveDepartement(Departement departement) {
        this.departementService.saveDepartement(departement);
    }

    @Override
    public Departement getDepartementById(long id) {
        Optional< Departement > optional = Optional.ofNullable(departementService.getDepartementById(id));
        Departement departement = null;
        if (optional.isPresent()) {
            departement = optional.get();
        } else {
            throw new RuntimeException(" Departement not found for id :: " + id);
        }
        return departement;
    }

    @Override
    public void deleteDepartementById(long id) {
        this.departementService.deleteDepartementById(id);
    }
}
