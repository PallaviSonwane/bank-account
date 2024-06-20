package com.crudOperation.Controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crudOperation.Entity.Account;
import com.crudOperation.Service.AccountService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/Account")
public class AccountController {

    @Autowired
    AccountService service;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
  public void createAccount(@RequestBody Account account){
        service.save(account);
  }

  @GetMapping("/getdata")
  public List<Account> getAllInfo(){
   return service.getAllAccounts();
  }

  @GetMapping("/{acc_no}")
  public Account getInfo(int acc_no){
      return service.getSelectedAccount(acc_no);
  }

 
}
