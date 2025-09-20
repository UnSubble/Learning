package com.unsubble.lesson4._01.controller;

import com.unsubble.lesson4._01.model.Product;
import com.unsubble.lesson4._01.model.ProductException;
import com.unsubble.lesson4._01.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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

        productService.addProduct(product);
        return "redirect:/products/form";
    }

    @RequestMapping(value = "/throwNumberFormat", method = RequestMethod.GET)
    public String throwNumberFormat() {
        throw new NumberFormatException();
    }

    @RequestMapping(value = "/throwProductEx", method = RequestMethod.GET)
    public String throwProductEx() {
        throw new ProductException();
    }

    // kullanmak için SimpleMappingExceptionResolver bean'ini devre dışı bırak.
/*    @ExceptionHandler(NumberFormatException.class)
    public String handleNumberFormat(NumberFormatException ex, Model model) {
        model.addAttribute("exception", ex);
        return "numberFormat";
    }*/

    @ModelAttribute("manufacturerMap")
    public Map<String, String> prepareManufacturers() {
        return Map.of("apple", "Apple", "samsung", "Samsung", "xiaomi", "Xiaomi");
    }

    @ModelAttribute("conditionsList")
    public List<String> prepareConditions() {
        return List.of("New", "Old", "Refurbished");
    }
}
