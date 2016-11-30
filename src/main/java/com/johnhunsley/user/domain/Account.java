package com.johnhunsley.user.domain;

import java.util.Collection;

/**
 * @author John Hunsley
 *         jphunsley@gmail.com
 *         Date : 30/11/2016
 *         Time : 12:38
 */
public interface Account {

    Collection<User> getUsers();

    void addUser(User user);

}
