package ru.example.mvcdocker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;
import ru.example.mvcdocker.entity.Customer;
import ru.example.mvcdocker.repos.CustomerRepo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dev team
 */

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerRepo customerRepo;

    public CustomerController(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @PostMapping
    public RedirectView addCustomer(@ModelAttribute("customer") Customer customer){
        System.out.println(customer);
         this.customerRepo.save(customer);
        return  new RedirectView( "/customer");
    }

    @GetMapping("/form")
    public String getCustomerFrom(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "customer-form";
    }

    @GetMapping
    public String getAllCustomers(Model model){
        List<Customer> customers = customerRepo.findAll();
//        model.addAttribute("customers", customers);
//        List<Customer> customers = new ArrayList<>();
//        Customer customer = new Customer();
//        customer.setId(1);
//        customer.setEmail("erqe@sada");
//        customer.setUsername("reerere");
//        customers.add(customer);
        model.addAttribute("customers", customers);

        return "customers";
    }
}
