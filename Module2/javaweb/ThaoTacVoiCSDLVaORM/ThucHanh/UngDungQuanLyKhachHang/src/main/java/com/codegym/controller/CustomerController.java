package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.repository.CustomerRepository;
import com.codegym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("customer",customerService.findAll());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/created")
    public ModelAndView saveCustomer(@RequestParam String firstname, String lastname){
        customerService.save(new Customer(firstname,lastname));
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("message", "New customer created successfully");
        modelAndView.addObject("customer",customerService.findAll());
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Customer customer = customerService.findById(id);
            ModelAndView modelAndView = new ModelAndView("edit");
            modelAndView.addObject("customer", customer);
            return modelAndView;


    }

    @PostMapping("/edited")
    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer){
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("customer",customerService.findAll());
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }


    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Customer customer = customerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }
    @PostMapping("/deleted")
    public ModelAndView deleteCustomer(@ModelAttribute("customer") Customer customer){
        customerService.remove(customer.getId());
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("customer",customerService.findAll());
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }
}
