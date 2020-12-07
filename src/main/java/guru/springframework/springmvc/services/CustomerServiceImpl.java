package guru.springframework.springmvc.services;

import guru.springframework.springmvc.domain.Customer;
import guru.springframework.springmvc.domain.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService{

    private Map<Integer, Customer> customers;

    public CustomerServiceImpl() {
        loadCustomers();
    }


    @Override
    public List<Customer> listAllCustomers() {

        return new ArrayList<>(customers.values());
    }

    private void loadCustomers(){

        customers = new HashMap<>();

        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setFirst_name("Aadhya");
        customer1.setLast_name("Rao");
        customer1.setPhone_number("9880498764");
        customer1.setAddress_line_1("Hosur Layout");
        customer1.setAddress_line_2("Near Temple");
        customer1.setCity("Bangalore");
        customer1.setState("Karnataka");
        customer1.setZip_code("580006");
        customer1.setEmail("aadhya@gmail.com");

        customers.put(1, customer1);

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setFirst_name("Ashwini");
        customer2.setLast_name("Chandrashekaran");
        customer2.setPhone_number("9524867217");
        customer2.setAddress_line_1("1980 Eagle Ridge Loop");
        customer2.setAddress_line_2("hello");
        customer2.setCity("Shakopee");
        customer2.setState("Minnesota");
        customer2.setZip_code("55379");
        customer2.setEmail("ashwini@gmail.com");

        customers.put(2, customer2);

        Customer customer3 = new Customer();
        customer3.setId(3);
        customer3.setFirst_name("Aditya");
        customer3.setLast_name("Chandrashekaran");
        customer3.setPhone_number("6127027890");
        customer3.setAddress_line_1("1980 Eagle Ridge Loop");
        customer3.setAddress_line_2("hello");
        customer3.setCity("Shakopee");
        customer3.setState("Minnesota");
        customer3.setZip_code("55379");
        customer3.setEmail("aditya@gmail.com");

        customers.put(3, customer3);

        Customer customer4 = new Customer();
        customer4.setId(4);
        customer4.setFirst_name("Rishi");
        customer4.setLast_name("Chandrashekaran");
        customer4.setPhone_number("612111888");
        customer4.setAddress_line_1("Dallas Street");
        customer4.setAddress_line_2("hello");
        customer4.setCity("Frisco");
        customer4.setState("TX");
        customer4.setZip_code("123456");
        customer4.setEmail("rishi@gmail.com");

        customers.put(4, customer4);

        Customer customer5 = new Customer();
        customer5.setId(5);
        customer5.setFirst_name("Yash");
        customer5.setLast_name("Chandrashekaran");
        customer5.setPhone_number("1112223333");
        customer5.setAddress_line_1("New Dallas Street");
        customer5.setAddress_line_2("hello");
        customer5.setCity("Dallas");
        customer5.setState("TX");
        customer5.setZip_code("554433");
        customer5.setEmail("yash@gmail.com");

        customers.put(5, customer5);
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customers.get(id);
    }
}
