package com.example.banner.service;

import com.example.banner.dao.CustomerDAO;
import com.example.banner.exception.CustomerNotFoundException;
import com.example.banner.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    public Customer addCustomer(Customer customer){
        return customerDAO.save(customer);
    }

    public List<Customer> getCustomers(){
        return customerDAO.findAll();
    }

    public Customer getCustomer(int customerId){

        Optional<Customer> optionalCustomer=customerDAO.findById(customerId);

        if(!optionalCustomer.isPresent())
            throw new CustomerNotFoundException("Customer Record is not available...");

        return optionalCustomer.get();
    }

    public Customer updateCustomer(int customerId, Customer customer){
        customer.setCustomerId(customerId);
        return customerDAO.save(customer);
    }

    public void deleteCustomer(int customerId){
        customerDAO.deleteById(customerId);
    }
}
