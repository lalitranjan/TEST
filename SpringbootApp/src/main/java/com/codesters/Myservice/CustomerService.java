package com.codesters.Myservice;

import com.codesters.model.Customer;
import com.codesters.model.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public int register(String name, String userName, String password, Date doB, long contact )
    {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setUserName(userName);
        customer.setContact(contact);
        customer.setPassword(password);
        customer.setDateOfBirth(doB);
        customerRepository.save(customer);
        return customer.getId();
    }

    public boolean logincheck(int id,String password)
    {
        Customer c = customerRepository.findById(id).get();
        if (c.getPassword().equals(password))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public Iterable<Customer> getAllCustomers()
    {
        return customerRepository.findAll();
    }

    public Customer getCustomerbyId(int id)
    {
        return customerRepository.findById(id).get();
    }
}
