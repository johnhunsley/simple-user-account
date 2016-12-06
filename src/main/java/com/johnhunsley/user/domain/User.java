package com.johnhunsley.user.domain;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;
import com.johnhunsley.user.util.UserTypeIdResolver;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author John Hunsley
 *         jphunsley@gmail.com
 *         Date : 30/11/2016
 *         Time : 12:41
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.CUSTOM,
        include = JsonTypeInfo.As.PROPERTY,
        property = "@class")
@JsonTypeIdResolver(UserTypeIdResolver.class)
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
