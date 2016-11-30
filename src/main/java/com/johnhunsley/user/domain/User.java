package com.johnhunsley.user.domain;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author John Hunsley
 *         jphunsley@gmail.com
 *         Date : 30/11/2016
 *         Time : 12:41
 */
public interface User extends UserDetails {

    Long getId();

    void setPasswordHash(byte[] passwordHash);

    Account getAccount();

    void setAccount(Account account);

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    String getEmail();

    void setEmail(String email);

    boolean isActive();

    void setActive(boolean active);

    void addRole(Role role);

    void setUsername(String s);
}
