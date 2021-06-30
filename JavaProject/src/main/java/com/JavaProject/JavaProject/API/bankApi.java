package com.JavaProject.JavaProject.API;

import com.JavaProject.JavaProject.Entity.Bank;
import com.JavaProject.JavaProject.Repo.bankRepo;
import com.JavaProject.JavaProject.Service.bankService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class bankApi {

    @Autowired
    private bankService bankservice;
    private bankRepo bankrepo;

    @PostMapping("/bank")
    public Bank createBank(@RequestBody Bank bank)
    {
        return bankservice.createBank(bank.getBankCode(),bank.getBankName(),bank.getAddress(),bank.getPinCode());
    }

    @GetMapping("/bank")
    private List<Bank> getAllBank()
    {
        return bankservice.getAllBank();
    }

    @GetMapping("/bank/{id}")
    private Bank getBank(@PathVariable("id") String id)
    {
        return bankservice.getBankById(id);
    }


    @DeleteMapping("/bank/{id}")
    private void deleteBank(@PathVariable("id") String id)
    {
        bankservice.deleteRecord(id);
    }


    //update Bank detail in the database
    @PostMapping("/bankupdate")
    private String updateBank(@RequestBody Bank bank)
    {
        bankservice.recordUpdate(bank);
        return bank.getBankCode();
    }


}
