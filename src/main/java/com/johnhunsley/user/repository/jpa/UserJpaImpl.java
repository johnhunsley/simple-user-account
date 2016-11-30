package com.johnhunsley.user.repository.jpa;

import com.johnhunsley.user.domain.Account;
import com.johnhunsley.user.domain.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author John Hunsley
 *         jphunsley@gmail.com
 *         Date : 30/11/2016
 *         Time : 12:51
 */
public class UserJpaImpl implements User {

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public Account getAccount() {
        return null;
    }

    @Override
    public void setAccount(Account account) {

    }

    @Override
    public String getFirstName() {
        return null;
    }

    @Override
    public void setFirstName(String firstName) {

    }

    @Override
    public String getLastName() {
        return null;
    }

    @Override
    public void setLastName(String lastName) {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
