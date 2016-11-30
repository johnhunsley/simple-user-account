package com.johnhunsley.user.repository.jpa.dynamo;

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
 *         Time : 12:55
 */
@Repository("userRepository")
@Profile("dynamo")
@EnableScan
public abstract class UserRepositoryDynamoImpl implements UserRepository, CrudRepository<UserDynamoImpl, Long> {

    @Override
    public abstract User findByUserName(String username);
}
