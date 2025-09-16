package com.unsubble.lesson3._01.dao;

import com.unsubble.lesson3._01.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    private List<Product> list;

    public ProductDAOImpl() {
        list = new ArrayList<>();

        list.add(new Product(
                "P1001",
                "Mechanical Keyboard",
                129.99,
                "RGB backlit mechanical keyboard with blue switches",
                "KeyMaster",
                "Peripherals",
                50,
                "New"
        ));

        list.add(new Product(
                "P1002",
                "Gaming Mouse",
                59.99,
                "High precision wireless gaming mouse",
                "SpeedClick",
                "Peripherals",
                120,
                "New"
        ));

        list.add(new Product(
                "P1003",
                "27-inch Monitor",
                289.49,
                "27-inch 144Hz 2K gaming monitor",
                "ViewPro",
                "Monitors",
                30,
                "Refurbished"
        ));

        list.add(new Product(
                "P1004",
                "USB-C Hub",
                34.99,
                "7-in-1 USB-C hub with HDMI, USB-A, and SD card reader",
                "Hubify",
                "Accessories",
                200,
                "New"
        ));

        list.add(new Product(
                "P1005",
                "External SSD 1TB",
                149.95,
                "Portable NVMe SSD with 1TB storage capacity",
                "DataFast",
                "Storage",
                75,
                "New"
        ));
    }

    @Override
    public List<Product> getAllProducts() {
        return List.copyOf(list);
    }

    @Override
    public Product getProductById(String productId) {
        return list.stream()
                .filter(x -> x.getProductId().equals(productId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void addProduct(Product product) {
        if (list.stream().anyMatch(x -> x.getProductId().equals(product.getProductId())))
            return;
        list.add(product);
    }
}
