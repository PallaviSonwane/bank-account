package com.crudOperation.Service;

import java.util.List;

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

   
    @Override
    public Account save(Account account) {
        try{
           String s= account.toString();
           System.out.println(s);
            return repo.save(account);
        }catch(Exception ex){
           
            log.info("error is in service"+ex);;
            return null;
        }
    }


    @Override
    public List<Account> getAllAccounts() {
       try{
            return repo.findAll();

       }catch(Exception ex){

            log.info("error in get all info"+ex);
            return null;
       }
    
    }


    @Override
    public Account getSelectedAccount(int acc_no) {
        boolean b=repo.exists(acc_no);
        try{
            if(b){
            return repo.findByAccountNumber(acc_no);
            }else{
                return null;
            }
        }catch(Exception ex){
            log.info("trubble in get account"+ex);
            return null;
        }
    }


}

   