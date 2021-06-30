package com.JavaProject.JavaProject.API;


import com.JavaProject.JavaProject.Entity.Transcation;
import com.JavaProject.JavaProject.Repo.transRepo;
import com.JavaProject.JavaProject.Service.transcationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class transcationApi {
    @Autowired
    private transcationService transcationservice;
    private transRepo transrepo;

    @GetMapping("/transc")
    private List<Transcation> getAllTrans()
    {
        return transcationservice.getAllTranscation();
    }

    @GetMapping("/transc/{id}")
    private List<Transcation> getAllTransByID(@PathVariable("id") String id)
    {
        return transcationservice.getAllTranscationById(id);
    }

/*
    @GetMapping("/transc/{id}/{date}")
    private List<Transcation> getAllTransByIDAndDate(@PathVariable("id") String id, @PathVariable("date")LocalDate date)
    {
        return transcationservice.getAllTranscationByIdAndDate(id,date);
    }*/

    @PostMapping("/credit/{id}/{credit}")
    private String creditAmount(@PathVariable("id") String id,@PathVariable("credit") double credit)
    {
        transcationservice.creditAmount(id,credit);
        return "Transcation is done sucessfully.";
    }

    @PostMapping("/debit/{id}/{debit}")
    private String debitAmount(@PathVariable("id") String id,@PathVariable("debit") double debit)
    {
        transcationservice.debitAmount(id,debit);
         return "Transcation is done sucessfully.";
    }

    @PostMapping("/transfer/{id1}/{id2}/{amount}")
    private String debitAmount(@PathVariable("id1") String id1,@PathVariable("id2") String id2,@PathVariable("amount") double amount) {

        return transcationservice.moneyTransfer(id1, id2, amount);
    }
}
