package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.model.Province;
import com.codegym.repository.CustomerRepository;
import com.codegym.service.CustomerService;
import com.codegym.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    ProvinceService provinceService;

    @ModelAttribute("provinces")
    public Iterable<Province> provinces() {
        return provinceService.findAll();
    }

    @GetMapping("/")
    public ModelAndView index(@PageableDefault(size = 5) Pageable pageable, @RequestParam("s") Optional<String> s) {
        ModelAndView modelAndView = new ModelAndView("/customer/index");
        String keywordLast = null;
        if (s.isPresent()) {
            keywordLast = s.get();
            modelAndView.addObject("customer", customerService.findAllByFirstNameContaining(keywordLast, pageable));
        } else {
            modelAndView.addObject("customer", customerService.findAll(pageable));
        }
        modelAndView.addObject("customerr", keywordLast);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/created")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Customer customer = customerService.findById(id).orElse(null);
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("id", id);
        return modelAndView;


    }

    @PostMapping("/edited")
    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer, @PageableDefault(size = 5) Pageable pageable) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/index");
        modelAndView.addObject("customer", customerService.findAll(pageable));
        return modelAndView;
    }


    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Customer customer = customerService.findById(id).orElse(null);
        ModelAndView modelAndView = new ModelAndView("/customer/delete");
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }


    @PostMapping("/deleted")
    public ModelAndView deleteCustomer(@ModelAttribute("customer") Customer customer,
                                       @PageableDefault(size = 5) Pageable pageable) {
        customerService.remove(customer.getId());
        ModelAndView modelAndView = new ModelAndView("/customer/index");
        modelAndView.addObject("customer", customerService.findAll(pageable));
        return modelAndView;
    }


}
