package com.crudOperation.Service;

import java.util.List;

import com.crudOperation.Entity.Account;

public interface AccountService {

    public Account save(Account account);
    public List<Account> getAllAccounts();
   public Account getSelectedAccount(int acc_no);

}
