package com.johnhunsley.user.repository;

import com.johnhunsley.user.domain.Account;

/**
 * @author John Hunsley
 *         jphunsley@gmail.com
 *         Date : 01/12/2016
 *         Time : 11:16
 */
public interface AccountRepository {

    void save(Account account);

    Account findById(Account account);
}
