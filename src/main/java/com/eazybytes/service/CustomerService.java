package com.eazybytes.service;

import com.eazybytes.model.Customer;
import org.springframework.stereotype.Service;


public interface CustomerService {

    public Customer registerUser(Customer customer);
}
