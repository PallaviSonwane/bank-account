package com.crudOperation.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.crudOperation.Entity.Account;

public interface AccountService {

    //create account
    public Account save(Account account);

    //get all acount list
    public List<Account> getAllAccounts();

    //get single account details
   public Optional<Account> getSelectedAccount(UUID acc_id);

   //delete account from database
   public boolean isDeleted(UUID acc_id);

   //update account 
   public boolean isUpdateAccount(UUID acc_id,Account account);

   //delete but not from databade
   public String deleteAccount(UUID acc_id);

}
