package com.customer.restapi.service;

import com.customer.restapi.dao.CustomerDao;
import com.customer.restapi.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class CustomerService {
    private final CustomerDao customerDao;

    @Autowired
    public CustomerService(@Qualifier("inMemoryDao") CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public void addCustomer(Customer customer) {
        customerDao.addCustomer(customer);
    }

    public List<Customer> getCustomerList() {
        return customerDao.getCustomerList();
    }

    @PostConstruct
    private void postConstruct() {
        for (int i = 0; i < 100; i++) {
            customerDao.addCustomer(new Customer("Test" + (i + 1), "Test" + (i + 1), "1991-01-01", "+123456789", "test" + (i + 1) + "@gmail.com"));
        }
    }
}
