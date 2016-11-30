package com.johnhunsley.user.repository.jpa.dynamo;

import com.johnhunsley.user.domain.Account;
import com.johnhunsley.user.domain.Role;
import com.johnhunsley.user.domain.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author John Hunsley
 *         jphunsley@gmail.com
 *         Date : 30/11/2016
 *         Time : 12:54
 */
public class UserDynamoImpl implements User {
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
    public void setPasswordHash(byte[] passwordHash) {

    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public void setEmail(String email) {

    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public void setActive(boolean active) {

    }

    @Override
    public void addRole(Role role) {

    }

    @Override
    public void setUsername(String s) {

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
