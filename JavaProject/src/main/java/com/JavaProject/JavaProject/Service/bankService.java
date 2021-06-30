package com.JavaProject.JavaProject.Service;

import com.JavaProject.JavaProject.Entity.Bank;
import com.JavaProject.JavaProject.Repo.bankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class bankService {

    @Autowired
    private bankRepo bankrepo;

    public Bank createBank(String bankId, String bankName, String Address, Integer pincode)
    {
        Bank bank = new Bank();
        bank.setBankCode(bankId);
        bank.setBankName(bankName);
        bank.setAddress(Address);
        bank.setPinCode(pincode);
        return bankrepo.save(bank);
    }

    public List<Bank> getAllBank()
    {
        List<Bank> bank = new ArrayList<Bank>();
        bankrepo.findAll().forEach(bank1 -> bank.add(bank1));
        return bank;
    }

    //getting a specific record
    public Bank getBankById(String id)
    {
        return bankrepo.findById(id).get();
    }

    public void recordUpdate(Bank bank)
    {
        bankrepo.save(bank);
    }
    //deleting a specific record
    public void deleteRecord(String id)
    {
        bankrepo.deleteById(id);
    }
}
