package com.johnhunsley.user.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Collection;

/**
 * @author John Hunsley
 *         jphunsley@gmail.com
 *         Date : 30/11/2016
 *         Time : 12:38
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public interface Account {

    Integer getId();

    Collection<? extends User> getUsers();

    void addUser(User user);

}
