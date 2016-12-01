package com.johnhunsley.user.repository;

import com.johnhunsley.user.domain.User;

/**
 * @author John Hunsley
 *         jphunsley@gmail.com
 *         Date : 30/11/2016
 *         Time : 12:49
 */
public interface UserRepository {

    User findByUsername(String username);

    void save(User user);

    User findById(Long id);

}
