package com.unsubble.lesson3._01.validator;

import com.unsubble.lesson3._01.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProductValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;

        if (product.getProductId() == null || product.getProductId().trim().length() < 5) {
            errors.rejectValue("productId", "required.productId");
            return;
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productId", "required.productId");
    }
}
