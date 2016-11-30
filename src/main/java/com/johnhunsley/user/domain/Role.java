package com.johnhunsley.user.domain;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author John Hunsley
 *         jphunsley@gmail.com
 *         Date : 30/11/2016
 *         Time : 12:41
 */
public interface Role extends GrantedAuthority {

    Integer getId();
}
