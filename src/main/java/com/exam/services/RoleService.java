package com.exam.services;
import com.exam.models.Role;

import java.util.List;


public interface RoleService {


    void saveRole(Role Role);
    Role getRoleById(long id);
    void deleteRoleById(long id);

    List<Role> findAll();
}
