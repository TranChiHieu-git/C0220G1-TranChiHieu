package com.codegym.controller;

import com.codegym.model.Cart;
import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    ProductService productService;

    @ModelAttribute("cart")
    public Cart setUpCounter() {
        return new Cart();
    }

    @GetMapping("/")
    public ModelAndView showList(@ModelAttribute("cart") Cart cart) {
        ModelAndView modelAndView = new ModelAndView("index");
        Iterable<Product> listProduct = productService.findAllProduct();
        modelAndView.addObject("productList", listProduct);
        return modelAndView;
    }

    @GetMapping("/product/{id}")
    public ModelAndView showProduct(@PathVariable("id") int id, @ModelAttribute("cart") Cart cart) {
        ModelAndView modelAndView = new ModelAndView("product");
        Optional<Product> product = productService.findProductById(id);
        modelAndView.addObject("aproduct", product);
        return modelAndView;
    }

    @GetMapping("/buy/{id}")
    public ModelAndView buyProduct(@PathVariable("id") int id, @ModelAttribute("cart") Cart cart) {
        ModelAndView modelAndView = new ModelAndView("product");
        Optional<Product> product = productService.findProductById(id);
        boolean have = false;
        for (Map.Entry<String, Optional<Product>> entry : cart.getListProduct().entrySet()) {
            if (entry.getValue().get().getName().equals(product.get().getName())) {
                have = true;
                break;
            }
        }
        if (have == false) {
            cart.addProduct(product);
            cart.getListProduct().get(product.get().getName()).get().addAmount();
        } else {
            for (Map.Entry<String, Optional<Product>> entry : cart.getListProduct().entrySet()) {
                if (entry.getValue().get().getName().equals(product.get().getName())) {
                    entry.getValue().get().addAmount();
                    break;
                }
            }
        }
        modelAndView.addObject("aproduct", product);
        return modelAndView;
    }

    @GetMapping("/cart")
    public ModelAndView cart(@ModelAttribute("cart") Cart cart) {
        ModelAndView modelAndView = new ModelAndView("cart");
        cart.setTotal(0);
        cart.sumMoney();
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView cart(@PathVariable("id") int id, @ModelAttribute("cart") Cart cart) {
        ModelAndView modelAndView = new ModelAndView("cart");
        Optional<Product> product = productService.findProductById(id);
        cart.getListProduct().remove(product.get().getName());
        cart.setTotal(0);
        cart.sumMoney();
        cart.setCount((cart.getListProduct().size()));
        return modelAndView;
    }

    @GetMapping("/up/{id}")
    public ModelAndView upAmount(@PathVariable("id") int id, @ModelAttribute("cart") Cart cart) {
        ModelAndView modelAndView = new ModelAndView("cart");
        Optional<Product> product = productService.findProductById(id);
        boolean have = false;
        for (Map.Entry<String, Optional<Product>> entry : cart.getListProduct().entrySet()) {
            if (entry.getValue().get().getName().equals(product.get().getName())) {
                have = true;
                break;
            }
        }
        if (have == false) {
            cart.addProduct(product);
            cart.getListProduct().get(product.get().getName()).get().addAmount();
        } else {
            for (Map.Entry<String, Optional<Product>> entry : cart.getListProduct().entrySet()) {
                if (entry.getValue().get().getName().equals(product.get().getName())) {
                    entry.getValue().get().addAmount();
                    break;
                }
            }
        }
        cart.setTotal(0);
        cart.sumMoney();
        modelAndView.addObject("aproduct", product);
        return modelAndView;
    }

    @GetMapping("/down/{id}")
    public ModelAndView downAmount(@PathVariable("id") int id, @ModelAttribute("cart") Cart cart) {
        ModelAndView modelAndView = new ModelAndView("cart");
        Optional<Product> product = productService.findProductById(id);
        if (cart.getListProduct().get(product.get().getName()).get().getAmount() > 1) {
            for (Map.Entry<String, Optional<Product>> entry : cart.getListProduct().entrySet()) {
                if (entry.getValue().get().getName().equals(product.get().getName())) {
                    entry.getValue().get().delAmount();
                    break;
                }
            }
        } else {
            cart.getListProduct().remove(product.get().getName());
            cart.setCount((cart.getListProduct().size()));
        }
        cart.setTotal(0);
        cart.sumMoney();
        modelAndView.addObject("aproduct", product);
        return modelAndView;
    }
}
