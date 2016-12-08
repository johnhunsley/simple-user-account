package com.johnhunsley.user.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author John Hunsley
 *         jphunsley@gmail.com
 *         Date : 30/11/2016
 *         Time : 12:41
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public interface Role extends GrantedAuthority {

    Integer getId();

    void setAuthority(String authority);
}
