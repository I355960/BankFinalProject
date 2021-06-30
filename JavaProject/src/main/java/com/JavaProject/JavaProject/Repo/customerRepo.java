package com.JavaProject.JavaProject.Repo;


import com.JavaProject.JavaProject.Entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface customerRepo extends CrudRepository<Customer,String> {

    List<Customer>findBycustomerNameContaining(String customerName);
}
