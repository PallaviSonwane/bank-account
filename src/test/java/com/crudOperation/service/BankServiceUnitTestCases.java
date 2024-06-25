package com.crudoperation.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import java.util.*;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.crudOperation.Entity.Account;
import com.crudOperation.Repository.AccountRepository;
import com.crudOperation.Service.AccountServiceImp;

@SpringBootTest
public class BankServiceUnitTestCases {

    @Mock
    private AccountRepository repo;

    @InjectMocks
    private AccountServiceImp service;

   

    @Test
    public void TestSaveAccount(){
        Account account =new Account();
        account.setAcc_id(UUID.randomUUID());

        when(repo.existsById(account.getAcc_id())).thenReturn(false);
       
        assertNotNull(account);
        service.isAccountAdd(account);
        verify(repo,times(1)).existsById(account.getAcc_id());
        verify(repo,times(1)).save(account);
    }

    @Test
    public void TestGetAllData(){
        List<Account> list = new ArrayList<>();
    
     // Create LocalDateTime object
     LocalDateTime dateTime = LocalDateTime.of(2024, 8, 4, 12, 0, 0);

     // Create Account object using constructor
     list.add(new Account(UUID.randomUUID(), 123456, 123.3, "gpay", "saving", dateTime, false));
     list.add(new Account(UUID.randomUUID(), 234567, 321.3, "phone pay", "debit", dateTime, false));
     when(repo.findAll()).thenReturn(list);
     
     List<Account> returnlist=service.getAllAccounts();
     
     assertEquals(list.get(0), returnlist.get(0));
     assertEquals(list.get(1), returnlist.get(1));

     assertEquals(list, returnlist , "Both list should be equal");

     assertEquals(2, returnlist.size() , "list size should be two");

     //Checks how many times finaAll() method calls
     verify(repo, times(1)).findAll();

    }
    
}
