package com.springboot.webapp.controller;

import com.springboot.webapp.entity.Customer;
import com.springboot.webapp.service.CustomerService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    private CustomerService customerService;


    public CustomerController(CustomerService theCustomerService){
        customerService = theCustomerService;
    }

//    @GetMapping("/")
//    public String helloWorld(){
//        return "helloworldblahhlbkaaa";
//    }

    @GetMapping("/list")
    public String listCustomers(Model theModel) {

        List<Customer> theCustomer = customerService.findAll();
        // add to the spring model
        theModel.addAttribute("customers", theCustomer);
        return "customers/list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer", theCustomer);
        return "customers/customer-form";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){

        customerService.save(theCustomer);

        return "redirect:/customers/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customersId")int theId, Model theModel){
        Customer theCustomer = customerService.findById(theId);
        theModel.addAttribute("customer",theCustomer);
        return "customers/customer-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("customersId")int theId){
        customerService.deleteById(theId);
        return "redirect:/customers/list";
    }

}
