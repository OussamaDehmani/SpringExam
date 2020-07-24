package com.exam.services;
import com.exam.models.Departement;
import com.exam.models.Remuneration;

import java.util.List;


public interface RemunerationService {


    void saveRemuneration(Remuneration remuneration);
    Remuneration getRemunerationById(long id);
    void deleteRemunerationById(long id);
    List<Remuneration> findAll();
}
