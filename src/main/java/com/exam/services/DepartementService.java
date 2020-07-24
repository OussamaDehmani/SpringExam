package com.exam.services;
import com.exam.models.Departement;

import java.util.List;


public interface DepartementService {


    void saveDepartement(Departement departement);
    Departement getDepartementById(long id);
    void deleteDepartementById(long id);

    List<Departement> findAll();
}
