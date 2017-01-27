package com.johnhunsley.user.service;

import com.johnhunsley.user.domain.Page;
import com.johnhunsley.user.domain.Role;
import com.johnhunsley.user.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

/**
 * @author John Hunsley
 *         jphunsley@gmail.com
 *         Date : 27/01/2017
 *         Time : 10:51
 */
public abstract class RoleService<T extends RoleRepository> {

    @Autowired
    protected T roleRepository;

    public T getRoleRepository() {
        return roleRepository;
    }

    public void setRoleRepository(T roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Collection<? extends Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public abstract Page<? extends Role> pageAllRoles(int pageSize, int pageNumber);

    public Role getRole(final Integer id) {
        return roleRepository.findById(id);
    }

    public void saveRole(Role role) {
        roleRepository.save(role);
    }
}
