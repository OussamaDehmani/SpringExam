package com.exam.services;
import com.exam.models.Departement;
import com.exam.models.Remuneration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RemunerationServiceImpl implements RemunerationService {

    @Autowired
    private RemunerationService remunerationService;

    @Override
    public List <Remuneration> findAll() {
        return remunerationService.findAll();
    }

    @Override
    public void saveRemuneration(Remuneration remuneration) {
        this.remunerationService.saveRemuneration(remuneration);
    }

    @Override
    public Remuneration getRemunerationById(long id) {
        Optional< Remuneration > optional = Optional.ofNullable(remunerationService.getRemunerationById(id));
        Remuneration remuneration = null;
        if (optional.isPresent()) {
            remuneration = optional.get();
        } else {
            throw new RuntimeException(" Departement not found for id :: " + id);
        }
        return remuneration;
    }

    @Override
    public void deleteRemunerationById(long id) {
        this.remunerationService.deleteRemunerationById(id);
    }
}
