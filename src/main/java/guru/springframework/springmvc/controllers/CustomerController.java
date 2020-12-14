package guru.springframework.springmvc.controllers;

import guru.springframework.springmvc.domain.Customer;
import guru.springframework.springmvc.domain.Product;
import guru.springframework.springmvc.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/customers")
    public String getAllCustomers(Model model)
    {
        model.addAttribute("customers", customerService.listAllCustomers());
        return "customers";
    }

    @RequestMapping("/customer/{id}")
    public String getCustomersById(@PathVariable Integer id, Model model){
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "customer";
    }

    @RequestMapping("/customer/new")
    public String newCustomer(Model model){
        model.addAttribute("customer", new Customer());
        return "customerform";
    }

    @RequestMapping("/customer/edit/{id}")
    public String editCustomers(@PathVariable Integer id, Model model){
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "customerform";
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public String saveOrUpdateCustomer(Customer customer){

        Customer savedCustomer = customerService.saveOrUpdateCustomer(customer);
        return "redirect:/customer/" + savedCustomer.getId();
    }

    @RequestMapping("/customer/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id){
        customerService.deleteCustomer(id);
        return "redirect:/customers";
    }
}
