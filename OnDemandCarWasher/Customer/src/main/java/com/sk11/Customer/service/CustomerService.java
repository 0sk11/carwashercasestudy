package com.sk11.Customer.service;

import com.sk11.Customer.model.CustomerModel;
import com.sk11.Customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public void save(CustomerModel customerModel){
        customerRepository.save(customerModel);
    }

    public List<CustomerModel> findAll(){
        List<CustomerModel> customerList = customerRepository.findAll();
        if(customerList.size()>0){
            return customerList;
        }
        return null;
    }
    public String deleteById(String id){
        customerRepository.deleteById(id);
        return "Successfully Deleted";
    }


}
