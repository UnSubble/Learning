package com.unsubble.lesson3._01.controller;

import com.unsubble.lesson3._01.model.Product;
import com.unsubble.lesson3._01.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String formPage(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        model.addAttribute("product", new Product());
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String postForm(@ModelAttribute("product") Product product) {
        productService.addProduct(product);;
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
