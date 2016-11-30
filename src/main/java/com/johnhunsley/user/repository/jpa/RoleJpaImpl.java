package com.johnhunsley.user.repository.jpa;

import com.johnhunsley.user.domain.Role;

import javax.persistence.*;

/**
 * @author John Hunsley
 *         jphunsley@gmail.com
 *         Date : 30/11/2016
 *         Time : 14:43
 */
@Entity
@Table(name = "ROLES")
public class RoleJpaImpl implements Role {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    @Basic
    @Column(name = "AUTHORITY")
    private String authority;

    @Override
    public Integer getId() {
        return Id;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
