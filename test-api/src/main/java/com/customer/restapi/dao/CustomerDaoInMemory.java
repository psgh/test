package com.customer.restapi.dao;

import com.customer.restapi.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("inMemoryDao")
public class CustomerDaoInMemory implements CustomerDao {

    private static int id = 1;
    private static List<Customer> customerList = new ArrayList<>();

    @Override
    public void addCustomer(Customer customer) {
        customer.setId(id);
        id++;
        customerList.add(customer);
    }

    @Override
    public List<Customer> getCustomerList() {
        return customerList;
    }
}
