package com.eazybytes.service.impl;

import com.eazybytes.model.Customer;
import com.eazybytes.repository.CustomerRepository;
import com.eazybytes.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Customer registerUser(Customer customer) {
        return customerRepository.save(customer);
    }
}
