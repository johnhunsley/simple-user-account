package com.johnhunsley.user.repository.map;

import com.johnhunsley.user.domain.User;
import com.johnhunsley.user.repository.UserRepository;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author John Hunsley
 *         jphunsley@gmail.com
 *         Date : 30/11/2016
 *         Time : 16:11
 */
@Repository("userRepository")
@Profile("map")
public class UserRepositoryMapImpl implements UserRepository {
    private Map<Long, User> map;
    private Long sequence;

    @PostConstruct
    public void init() {
        map = new Hashtable<>();
        sequence = 0L;
    }

    @Override
    public User findByUserName(String username) {
        for(Long id : map.keySet()) {
            User user = map.get(id);

            if(user.getUsername().equalsIgnoreCase(username)) return user;
        }

        return null;
    }

    @Override
    public void save(User user) {
        if(map == null) init();

        if(user.getId() == null || user.getId() < 1) {

            synchronized(this) {
                sequence++;

                try {
                    PropertyUtils.setProperty(user, "id", sequence);

                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }

        map.put(user.getId(), user);
    }

    @Override
    public User findById(Long id) {
        return map.get(id);
    }
}
