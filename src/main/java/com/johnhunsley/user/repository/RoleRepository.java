package com.johnhunsley.user.repository;

import com.johnhunsley.user.domain.Role;

import java.util.Collection;

/**
 * @author John Hunsley
 *         jphunsley@gmail.com
 *         Date : 01/12/2016
 *         Time : 13:35
 */
public interface RoleRepository<T extends Role> {

    Collection<T> findAll();

    void save(T role);

    Role findById(Integer id);

}
