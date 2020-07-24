package com.exam.services;
import com.exam.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleService RoleService;

    @Override
    public List <Role> findAll() {
        return RoleService.findAll();
    }

    @Override
    public void saveRole(Role Role) {
        this.RoleService.saveRole(Role);
    }

    @Override
    public Role getRoleById(long id) {
        Optional< Role > optional = Optional.ofNullable(RoleService.getRoleById(id));
        Role Role = null;
        if (optional.isPresent()) {
            Role = optional.get();
        } else {
            throw new RuntimeException(" Role not found for id :: " + id);
        }
        return Role;
    }

    @Override
    public void deleteRoleById(long id) {
        this.RoleService.deleteRoleById(id);
    }
}
