package com.JavaProject.JavaProject.Service;

import com.JavaProject.JavaProject.Entity.Account;
import com.JavaProject.JavaProject.Entity.Transcation;
import com.JavaProject.JavaProject.Repo.accountRepo;
import com.JavaProject.JavaProject.Repo.transRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*import java.time.LocalDate;*/
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class accountService {

    @Autowired
    private accountRepo accountrepo;
    @Autowired
    private transcationService transcationservice;

    public Account createAccount(String accountId, String accountType, double totalBalance)
    {
        Account account = new Account();
        Transcation transcation = new Transcation();
        account.setAccountNumber(accountId);
        account.setAccountType(accountType);
        //account.setAccountOpenDate(accountOpenDate);
        /* Add into Transcation table */
         transcation.setAccountNumber(accountId);
        transcation.setCreditBalance(totalBalance);
        transcation.setTotalAmount(totalBalance);
        account.setTotalBalance(totalBalance);
        transcationservice.createTranscation(transcation.getAccountNumber(),transcation.getDebitBalance(),transcation.getCreditBalance(),transcation.getTotalAmount());
        //transrepo.save(transcation);
        return accountrepo.save(account);
    }

    public List<Account> getAllAccount()
    {
        List<Account> account = new ArrayList<Account>();
        accountrepo.findAll().forEach(account1 -> account.add(account1));
        return account;
    }

    //getting a specific record
    public Account getAccountById(String id)
    {
        return accountrepo.findById(id).get();
    }

    public void accountUpdate(Account account)
    {
        accountrepo.save(account);
    }
    //deleting a specific record
    public void deleteAccount(String id)
    {
        accountrepo.deleteById(id);
    }
}
