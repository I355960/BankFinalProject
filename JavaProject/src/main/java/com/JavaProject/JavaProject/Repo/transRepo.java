package com.JavaProject.JavaProject.Repo;


import com.JavaProject.JavaProject.Entity.Transcation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface transRepo extends CrudRepository<Transcation,String> {

    List<Transcation>findByaccountNumber(String accountNumber);
    //List<Transcation>findByaccountNumberAndtransDate(String accountNumber,LocalDate date);
}
