package com.johnhunsley.user.repository.jpa;

import com.johnhunsley.user.domain.User;
import com.johnhunsley.user.repository.UserRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author John Hunsley
 *         jphunsley@gmail.com
 *         Date : 30/11/2016
 *         Time : 12:52
 */
@Repository("userRepository")
@Profile("jpa")
public abstract class UserRepositoryJpaImpl implements UserRepository, CrudRepository<UserJpaImpl, Long> {

    @Override
    public abstract User findByUserName(String username);
}
