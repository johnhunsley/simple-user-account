package com.johnhunsley.user.repository;

import com.johnhunsley.user.domain.Account;

/**
 * @author John Hunsley
 *         jphunsley@gmail.com
 *         Date : 01/12/2016
 *         Time : 11:16
 */
public interface AccountRepository<T extends Account> {

    void save(T account);

    Account findById(T account);
}
