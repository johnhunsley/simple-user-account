package com.johnhunsley.user.util;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.johnhunsley.user.domain.Account;
import com.johnhunsley.user.domain.Role;
import com.johnhunsley.user.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

/**
 * @author John Hunsley
 *         jphunsley@gmail.com
 *         Date : 13/01/2017
 *         Time : 15:55
 */
public class UserTypeIdResolverTest {

    UserTypeIdResolver resolver;

    @Before
    public void initResolver() {
        Field domainField = ReflectionUtils.findField(UserTypeIdResolver.class, "domainImplPackage");
        Field suffixField = ReflectionUtils.findField(UserTypeIdResolver.class, "domainImplSuffix");
        resolver = new UserTypeIdResolver();
        resolver.init(SimpleType.constructUnsafe(UserMockImpl.class));
        ReflectionUtils.makeAccessible(domainField);
        ReflectionUtils.setField(domainField, resolver, "com.johnhunsley.user.util");
        ReflectionUtils.makeAccessible(suffixField);
        ReflectionUtils.setField(suffixField, resolver, "MockImpl");
    }


    @Test
    public void testIdFromValueAndType() throws Exception {
        final String id = resolver.idFromValueAndType(null, UserMockImpl.class);
        assertTrue(id.equals("UserTypeIdResolverTest$User"));
    }

    @Test
    public void testTypeFromId() throws Exception {
        JavaType type = resolver.typeFromId(null, "UserTypeIdResolverTest$User");
        assertTrue(type.getTypeName().equals("[simple type, class com.johnhunsley.user.util.UserTypeIdResolverTest$UserMockImpl]"));
    }

    /**
     *
     */
    public class UserMockImpl implements User {

        public Long getId() {
            return 0L;
        }

        public void setPasswordHash(byte[] passwordHash) {

        }

        public Account getAccount() {
            return null;
        }

        public void setAccount(Account account) {

        }

        public String getFirstName() {
            return null;
        }

        public void setFirstName(String firstName) {

        }

        public String getLastName() {
            return null;
        }

        public void setLastName(String lastName) {

        }

        public String getEmail() {
            return null;
        }

        public void setEmail(String email) {

        }

        public boolean isActive() {
            return false;
        }

        public void setActive(boolean active) {

        }

        public void addRole(Role role) {

        }

        public void setUsername(String s) {

        }

        public Collection<? extends Role> getRoles() {
            return null;
        }

        public Collection<? extends GrantedAuthority> getAuthorities() {
            return null;
        }

        public String getPassword() {
            return null;
        }

        public String getUsername() {
            return null;
        }

        public boolean isAccountNonExpired() {
            return false;
        }

        public boolean isAccountNonLocked() {
            return false;
        }

        public boolean isCredentialsNonExpired() {
            return false;
        }

        public boolean isEnabled() {
            return false;
        }
    }
}
