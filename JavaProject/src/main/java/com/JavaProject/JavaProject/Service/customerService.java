package com.JavaProject.JavaProject.Service;

import com.JavaProject.JavaProject.Entity.Customer;
import com.JavaProject.JavaProject.Repo.customerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class customerService {

    @Autowired
    private customerRepo customerrepo;

    public Customer createCustomer(String customerId, String pancard, String customerName,String email, String address, Integer pincode)
    {
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        customer.setPanCard(pancard);
        customer.setCustomerName(customerName);
        customer.setEmail(email);
        customer.setCustomerAddress(address);
        customer.setCustomerPinCode(pincode);
        return customerrepo.save(customer);
    }

    public List<Customer> getAllcustomer()
    {
        List<Customer> customer = new ArrayList<Customer>();
        customerrepo.findAll().forEach(customer1 -> customer.add(customer1));
        return customer;
    }

    //getting a specific record
    public Customer getCustomerById(String id)
    {
        return customerrepo.findById(id).get();
    }

    public List<Customer> getCustomerName(String customerName)
    {
        List<Customer> customer = new ArrayList<Customer>();
        customerrepo.findBycustomerNameContaining(customerName).forEach(customer1 -> customer.add(customer1));
        return customer;

    }


    public void recordUpdate(Customer customer)
    {
        customerrepo.save(customer);
    }
    //deleting a specific record
    public void deleteRecord(String id)
    {
        customerrepo.deleteById(id);
    }

}
