package com.johnhunsley.user;

import com.johnhunsley.user.domain.User;
import com.johnhunsley.user.repository.UserRepository;
import com.johnhunsley.user.repository.jpa.UserJpaImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

/**
 * @author John Hunsley
 *         jphunsley@gmail.com
 *         Date : 30/11/2016
 *         Time : 16:28
 */
@SpringBootConfiguration
@EnableJpaRepositories("com.johnhunsley.user.repository.map")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles(profiles = "map")
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testReadWrite() {
        User user = new UserJpaImpl();
        user.setUsername("Bob");
        userRepository.save(user);

        User persistedUser = userRepository.findByUserName("Bob");
        assertTrue(persistedUser.getId() > 0);
    }


}
