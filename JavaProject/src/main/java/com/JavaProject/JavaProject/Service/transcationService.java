package com.JavaProject.JavaProject.Service;


import com.JavaProject.JavaProject.Entity.Account;
import com.JavaProject.JavaProject.Entity.Transcation;
import com.JavaProject.JavaProject.Repo.accountRepo;
import com.JavaProject.JavaProject.Repo.transRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class transcationService {

    @Autowired
    private transRepo transrepo;
    @Autowired
    private  accountRepo accountrepo;
    @Autowired
    private Account account;
    @Autowired
    private accountService accountservice;

    public Transcation createTranscation(String accountNo,double debit, double credit,double total)
    {
        Transcation transcation = new Transcation();
        transcation.setAccountNumber(accountNo);
        transcation.setCreditBalance(credit);
        transcation.setDebitBalance(debit);
        transcation.setTotalAmount(total);
        return transrepo.save(transcation);
    }

    public List<Transcation> getAllTranscation()
    {
        List<Transcation> transcation = new ArrayList<Transcation>();
        transrepo.findAll().forEach(transcation1 -> transcation.add(transcation1));
        return transcation;
    }

    public List<Transcation> getAllTranscationById(String Id)
    {
        List<Transcation> transcation1 = new ArrayList<Transcation>();
        transrepo.findByaccountNumber(Id).forEach(transcation2 -> transcation1.add(transcation2));
        return transcation1;
    }

/*
    public List<Transcation> getAllTranscationByIdAndDate(String Id,LocalDate date)
    {
        List<Transcation> transcation1 = new ArrayList<Transcation>();
        transrepo.findByaccountNumberAndtransDate(Id,date).forEach(transcation2 -> transcation1.add(transcation2));
        return transcation1;
    }*/


    public void creditAmount(String id,double credit)
    {
        //Account account;
        double amount_credit_or_debit;
        account = accountservice.getAccountById(id);
        amount_credit_or_debit = account.getTotalBalance();
        amount_credit_or_debit = amount_credit_or_debit + credit;
        account.setTotalBalance(amount_credit_or_debit);
        createTranscation(account.getAccountNumber(),0, credit,amount_credit_or_debit);
        accountrepo.save(account);
    }

    public void debitAmount(String id,double debit)
    {
        //Account account;
        double amount_credit_or_debit;
        account = accountservice.getAccountById(id);
        amount_credit_or_debit = account.getTotalBalance();
        if (amount_credit_or_debit>debit)
        {
            amount_credit_or_debit = amount_credit_or_debit - debit;
            account.setTotalBalance(amount_credit_or_debit);
            createTranscation(account.getAccountNumber(), debit, 0, amount_credit_or_debit);
            accountrepo.save(account);
        }
    }

    public String moneyTransfer(String sendId, String reciveId, double amount)
    {
        double amountDebit;
        account = accountservice.getAccountById(sendId);
        if (account.getTotalBalance()>amount)
        {
            debitAmount(sendId,amount);
            creditAmount(reciveId,amount);
            String mesg =  "Your amount " +amount +" is transfer to account no: " +reciveId;
            return mesg;
        }
        else
            return "Insufficent money to transfer";


    }
}
