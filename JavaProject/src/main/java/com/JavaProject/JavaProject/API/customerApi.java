package com.JavaProject.JavaProject.API;

import com.JavaProject.JavaProject.Entity.Customer;
import com.JavaProject.JavaProject.Repo.customerRepo;
import com.JavaProject.JavaProject.Service.customerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class customerApi {

    @Autowired
    private customerService customerservice;
    private customerRepo customerrepo;

    @PostMapping("/customer")
    public Customer createCustomer(@RequestBody Customer customer)
    {
        return customerservice.createCustomer(customer.getCustomerId(),customer.getPanCard(),customer.getCustomerName(),customer.getEmail(),customer.getCustomerAddress(),customer.getCustomerPinCode());
    }

    @GetMapping("/customer")
    private List<Customer> getAllCustomer()
    {
        return customerservice.getAllcustomer();
    }

    @GetMapping("/customer/{id}")
    private Customer getCustomer(@PathVariable("id") String id)

    {
        return customerservice.getCustomerById(id);
    }

    @GetMapping("/customer/by/{name}")
    private List<Customer> getCustomerByName(@PathVariable("name") String name)

    {
        return customerservice.getCustomerName(name);
    }


    @DeleteMapping("/customer/{id}")
    private void deleteBank(@PathVariable("id") String id)
    {
        customerservice.deleteRecord(id);
    }


    //update customer detail in the database
    @PostMapping("/customerupdate")
    private String updateBank(@RequestBody Customer customer)
    {
        customerservice.recordUpdate(customer);
        return customer.getCustomerId();
    }
}
