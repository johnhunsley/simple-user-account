package com.johnhunsley.user.repository;

import com.johnhunsley.user.domain.Role;

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
 *         Date : 01/12/2016
 *         Time : 19:35
 */
public interface RoleRepository<T extends Role> {

    Collection<T> findAll();

    void save(T role);

    Role findById(Integer id);

}
