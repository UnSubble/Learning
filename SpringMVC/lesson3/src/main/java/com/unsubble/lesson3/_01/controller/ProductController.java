package com.unsubble.lesson3._01.controller;

import com.unsubble.lesson3._01.model.Product;
import com.unsubble.lesson3._01.service.ProductService;
import com.unsubble.lesson3._01.validator.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductValidator productValidator;
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService, ProductValidator validator) {
        this.productService = productService;
        this.productValidator = validator;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(productValidator);
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String formPage(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        model.addAttribute("product", new Product());
        return "form";
    }

    /*@RequestMapping(value = "/form", method = RequestMethod.POST)
    public String postForm(@ModelAttribute("product") Product product) {
        productService.addProduct(product);
        return "redirect:/products/form";
    }*/

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String postForm(@ModelAttribute("product") @Validated Product product,
                           BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("products", productService.getAllProducts());
            return "form";
        }

        productService.addProduct(product);
        return "redirect:/products/form";
    }

    @ModelAttribute("manufacturerMap")
    public Map<String, String> prepareManufacturers() {
        return Map.of("apple", "Apple", "samsung", "Samsung", "xiaomi", "Xiaomi");
    }

    @ModelAttribute("conditionsList")
    public List<String> prepareConditions() {
        return List.of("New", "Old", "Refurbished");
    }
}
