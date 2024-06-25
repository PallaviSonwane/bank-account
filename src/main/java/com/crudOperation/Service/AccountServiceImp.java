package com.crudOperation.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudOperation.Entity.Account;
import com.crudOperation.Repository.AccountRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j 
public class AccountServiceImp implements AccountService {

    @Autowired
    AccountRepository repo;
   
    //insert data
    @Override
    public boolean isAccountAdd(Account account) {
        boolean b=repo.existsById(account.getAcc_id());
        try{
            if(b){
                return false;
            }else{
               
                repo.save(account);
                return true;
            }
          
        }catch(Exception ex){
           
            log.error("error is in service"+ex);;
            return false;
        }
    }


    //view all account
    @Override
    public List<Account> getAllAccounts() {
       try{ 
            return repo.findAll();

       }catch(Exception ex){

            log.error("error in get all info"+ex);
            return null;
       }
    
    }


    //get account by id
     @Override
    public Optional<Account> getSelectedAccount(UUID acc_id) {
        boolean b=repo.existsById(acc_id);
        try{
            if(b){
                Optional<Account> op= repo.findById(acc_id);
                return op;
            }else{
                return null;
            }
        }catch(Exception ex){
            log.error("trubble in get account"+ex);
            return null;
        }
    }


    //delete account from database
    @Override
    public boolean isDeleted(UUID acc_id) {
        boolean b=repo.existsById(acc_id);
       try{
        if(b){
            repo.deleteById(acc_id);
            return true;
        }else{
            return false;
        }
       }catch(Exception ex){
            log.error("account not deleted"+ex);
            return false;
       }
    }


    //update acount from database
    @Override
    public boolean isUpdateAccount(UUID acc_id, Account account) {
        boolean b=repo.existsById(acc_id);
        try{
            if(b){
                repo.save(account);
                return true;
            }else{
                return false;
            }
        }catch(Exception ex){
            log.error("not updated"+ex);
            System.out.println("hello");
            return false;
        }
    }


    @Override
    public String deleteAccount(UUID acc_id) {
        Optional<Account> account=repo.findById(acc_id);
        if(account.isPresent()){
            Account acc=account.get();
            if(acc.isDeleted()){
                return "this account is already deleted";
            }
            acc.setDeleted(true);
            repo.save(acc);
        }else{
           return "this account not found";
        }
        return "account deleted";
    }


}

   