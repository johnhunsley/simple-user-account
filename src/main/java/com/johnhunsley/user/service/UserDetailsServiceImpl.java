package com.johnhunsley.user.service;

import com.johnhunsley.user.domain.Account;
import com.johnhunsley.user.domain.User;
import com.johnhunsley.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

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
 *         Date : 30/11/2016
 *         Time : 19:48
 */
public abstract class UserDetailsServiceImpl<T extends UserRepository> implements UserDetailsService {

    @Autowired
    protected T userRepository;

    public T getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(T userRepository) {
        this.userRepository = userRepository;
    }

    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        return getUserByUsername(username);
    }

    public User getUserByUsername(final String username) {
        return userRepository.findByUsername(username);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User getById(final Long id) {
        return userRepository.findById(id);
    }

    public abstract Collection<? extends User> pageAllUser(int pageSize, int pageNumber);

    public abstract Collection<? extends User> pageAccountUsers(Account account,
                                                      int pageSize,
                                                      int pageNumber);

    public abstract Collection<? extends User> searchAllUsers(String query, int pageSize, int pageNumber);

    public abstract Collection<? extends User> searchAccountUsers(Account account,
                                                                  String query,
                                                                  int pageSize,
                                                                  int pageNumber);

}
