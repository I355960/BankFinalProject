package com.JavaProject.JavaProject.API;

import com.JavaProject.JavaProject.Entity.Account;
import com.JavaProject.JavaProject.Repo.accountRepo;
import com.JavaProject.JavaProject.Service.accountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class accountApi {

    @Autowired
    private accountService accountservice;
    @Autowired
    private accountRepo accountrepo;

    @PostMapping("/account")
    public Account createAccount(@RequestBody Account account)
    {
        return accountservice.createAccount(account.getAccountNumber(),account.getAccountType(),account.getTotalBalance());
    }

    @GetMapping("/account")
    private List<Account> getAllAccount()
    {
        return accountservice.getAllAccount();
    }

    @GetMapping("/account/{id}")
    private Account getAccount(@PathVariable("id") String id)
    {
        return accountservice.getAccountById(id);
    }


    @DeleteMapping("/account/{id}")
    private void deleteAccount(@PathVariable("id") String id)
    {
        accountservice.deleteAccount(id);
    }


    //update Account detail in the database
    @PostMapping("/accountupdate")
    private String updateBank(@RequestBody Account account)
    {
        accountservice.accountUpdate(account);
        return account.getAccountNumber();
    }
}
