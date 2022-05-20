package com.customer.restapi.dao;

import com.customer.restapi.model.Customer;

import java.util.List;

public interface CustomerDao {

    void addCustomer(Customer customer);

    public List<Customer> getCustomerList();
}
