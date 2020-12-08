package guru.springframework.springmvc.services;


import guru.springframework.springmvc.domain.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> listAllCustomers();
    Customer getCustomerById(Integer id);
    Customer saveOrUpdateCustomer(Customer customer);
    void deleteCustomer(Integer id);
}
