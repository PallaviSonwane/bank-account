package com.crudOperation.Controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crudOperation.Entity.Account;
import com.crudOperation.Service.AccountService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/Account")
public class AccountController {
  
    @Autowired
    private AccountService service;
   
    @RequestMapping(value = "/add", method = RequestMethod.POST)
  public String createAccount(@RequestBody Account account){
        boolean b=service.isAccountAdd(account);
        return b?"account saved":"not saved";
  }

  @GetMapping("/getdata")
  public List<Account> getAllInfo(){
   return service.getAllAccounts();

  }

  @GetMapping("/getbyid/{acc_id}")
  public Optional<Account> getInfo(@PathVariable UUID acc_id){
      return service.getSelectedAccount(acc_id);
  }

  @DeleteMapping("/deletebyid/{acc_id}")
  public String  deleteAccount(@PathVariable UUID acc_id){
    boolean b=service.isDeleted(acc_id);
    if(b){
      return "account deleted sussecfully";
    }else{
      return "account not deleted";
    }
  }

  @PutMapping("/updatebyid/{acc_id}")
  public String updateAccount(@PathVariable UUID acc_id,@RequestBody Account account){
    boolean b=service.isUpdateAccount(acc_id, account);
    return b?"account Updated":"account not updated";
  }

  @DeleteMapping("/delete/{acc_id}")
  public String AccountDeleted(@PathVariable UUID acc_id){
        return service.deleteAccount(acc_id);
  }

 
}
