package com.unsubble.lesson4._01.service;

import com.unsubble.lesson4._01.dao.ProductDAO;
import com.unsubble.lesson4._01.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO;

    @Autowired
    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    @Override
    public Product getProductById(String productId) {
        return productDAO.getProductById(productId);
    }

    @Override
    public void addProduct(Product product) {
        productDAO.addProduct(product);
    }
}
