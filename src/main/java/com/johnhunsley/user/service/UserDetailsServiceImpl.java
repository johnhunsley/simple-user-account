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
 * @author John Hunsley
 *         jphunsley@gmail.com
 *         Date : 30/11/2016
 *         Time : 12:48
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
