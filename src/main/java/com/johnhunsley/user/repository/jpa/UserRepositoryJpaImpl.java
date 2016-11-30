package com.johnhunsley.user.repository.jpa;

import com.johnhunsley.user.domain.User;
import com.johnhunsley.user.repository.UserRepository;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
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
@EnableScan
public interface UserRepositoryJpaImpl extends UserRepository, CrudRepository<UserJpaImpl, Long> {

    @Override
    User findByUserName(String username);
}
