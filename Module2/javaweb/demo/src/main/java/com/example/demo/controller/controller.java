package com.example.demo.controller;

import com.example.demo.Service.ProductService;
import com.example.demo.Service.TypeProductService;
import com.example.demo.model.Product;
import com.example.demo.model.TypeProduct;
import com.example.demo.model.validateProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;
import java.util.Optional;

@Controller
public class controller {
    @Autowired
    ProductService productService;
    @Autowired
    TypeProductService typeProductService;

    @ModelAttribute("typeprodcut")
    public Iterable<TypeProduct> typeProducts() {
        return typeProductService.findAllTypeProduct();
    }

    @GetMapping("/")
    public ModelAndView showProductList(@PageableDefault(size = 5) Pageable pageable, @RequestParam Optional<String> keyword) {
        ModelAndView modelAndView = new ModelAndView("index");
        String keywordLast = null;
        if (keyword.isPresent()) {
            keywordLast = keyword.get();
            modelAndView.addObject("listProduct", productService.findAllProductByname(keywordLast, pageable));
        } else {
            modelAndView.addObject("listProduct", productService.findAllProduct(pageable));
        }
        modelAndView.addObject("keyword", keywordLast);
        return modelAndView;
    }

    @GetMapping("/addProduct")
    public ModelAndView addProduct() {
        ModelAndView modelAndView = new ModelAndView("add");
        modelAndView.addObject("productNew", new validateProduct());
        return modelAndView;
    }

    @PostMapping("/added")
    public ModelAndView checkValidation(@Valid @ModelAttribute("productNew") validateProduct validateProduct,
                                        BindingResult bindingResult, @PageableDefault(size = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/add");
        if (bindingResult.hasErrors()) {
            return modelAndView;
        } else {
            modelAndView.setViewName("/index");
            Product product = new Product(validateProduct.getNameProduct(), validateProduct.getPriceProduct(), validateProduct.getAmountProdcut(),
                    validateProduct.getDescriptProduct(), typeProductService.findTypeProductById(validateProduct.getIdTypeProdcut()));
            Date date = new Date();
            product.setDateCreate(date);
            System.out.println(date);
            productService.saveProdcut(product);
            modelAndView.addObject("listProduct", productService.findAllProduct(pageable));
            return modelAndView;
        }
    }

    @GetMapping("/delete/{id}")
    ModelAndView deleteProdcuct(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("productById", productService.findProdcutById(id));
        return modelAndView;
    }

    @PostMapping("deleted")
    ModelAndView deletedProduct(@ModelAttribute("productById") Product productDeleted, @PageableDefault(size = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("index");
        productService.deleteProduct(productDeleted);
        modelAndView.addObject("listProduct", productService.findAllProduct(pageable));
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    ModelAndView editProdcut(@PathVariable("id") int id) {
        Product product = productService.findProdcutById(id);
        ModelAndView modelAndView = new ModelAndView("edit");
        validateProduct validateProduct = new validateProduct(product.nameProduct, product.priceProduct, product.amountProdcut, product.descriptProduct, product.getTypeProduct().getId());
        validateProduct.setId(id);
        modelAndView.addObject("productEdit", validateProduct);

        return modelAndView;
    }

    @PostMapping("/edited")
    public ModelAndView checkValidationEdit(@Valid @ModelAttribute("productEdit") validateProduct validateProduct,
                                            BindingResult bindingResult, @PageableDefault(size = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/edit");
        if (bindingResult.hasErrors()) {
            return modelAndView;
        } else {
            modelAndView.setViewName("/index");
            Product product = productService.findProdcutById(validateProduct.getId());
            product.setNameProduct(validateProduct.getNameProduct());
            product.setPriceProduct(validateProduct.getPriceProduct());
            product.setAmountProdcut(validateProduct.getAmountProdcut());
            product.setDescriptProduct(validateProduct.getDescriptProduct());
            product.setTypeProduct(typeProductService.findTypeProductById(validateProduct.getIdTypeProdcut()));
            Date date = new Date();
            product.setDateCreate(date);
            productService.saveProdcut(product);
            modelAndView.addObject("listProduct", productService.findAllProduct(pageable));
            return modelAndView;
        }
    }
}
