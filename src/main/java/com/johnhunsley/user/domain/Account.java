package com.johnhunsley.user.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

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
 *
 * @author John Hunsley
 *         jphunsley@gmail.com
 *         Date : 30/11/2016
 *         Time : 19:38
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public interface Account {

    Integer getId();

    Collection<? extends User> getUsers();

    void addUser(User user);

    String getName();

    void setName(String name);

}
