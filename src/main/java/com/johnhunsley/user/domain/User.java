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

    Account getAccount();

    void setAccount(Account account);

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);
}
