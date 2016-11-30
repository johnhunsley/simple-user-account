package com.johnhunsley.user.repository.jpa;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.johnhunsley.user.domain.Account;
import com.johnhunsley.user.domain.Role;
import com.johnhunsley.user.domain.User;
import com.johnhunsley.user.domain.YNEnum;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Base64;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author John Hunsley
 *         jphunsley@gmail.com
 *         Date : 30/11/2016
 *         Time : 12:51
 */
@Entity
@Table(name = "USERS")
public class UserJpaImpl implements User {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Basic
    @Column(name = "USERNAME")
    private String username;

    @Basic
    @Column(name = "PASSWORD")
    private String password;

    @Basic
    @Column(name = "EMAIL")
    private String email;

    @Basic
    @Column(name = "FIRSTNAME")
    private String firstName;

    @Basic
    @Column(name = "LASTNAME")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column
    private YNEnum active;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID", nullable = false)
    private Account account;

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", catalog = "user", schema = "",
            joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID", nullable = false))
    private Set<RoleJpaImpl> roles;

    @Override
    public Long getId() {
        return Id;
    }

    /**
     * <p>
     *     Set the password as a {@link Base64} encoded String of the
     *     given byte[] hash.
     * </p>
     * @param passwordHash
     */
    @Override
    public void setPasswordHash(byte[] passwordHash) {
        byte[] base64Hash = Base64.getEncoder().encode(passwordHash);
        password = new String(base64Hash);
    }

    @Override
    public Account getAccount() {
        return account;
    }

    @Override
    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public void setUsername(String s) {
        this.username = username;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean isActive() {
        return active.equals(YNEnum.Y);
    }

    @Override
    public void setActive(boolean active) {
        if(active) this.active = YNEnum.Y;
        else this.active = YNEnum.N;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public void addRole(Role role) {
        if(roles == null) roles = new HashSet<>();
        roles.add((RoleJpaImpl)role);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive();
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive();
    }

    @Override
    public boolean isEnabled() {
        return isActive();
    }
}
