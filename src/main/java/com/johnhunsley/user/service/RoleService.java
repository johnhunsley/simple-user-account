package com.johnhunsley.user.service;

import com.johnhunsley.user.domain.Page;
import com.johnhunsley.user.domain.Role;
import com.johnhunsley.user.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

/**
 * <p>
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 * </p>
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
