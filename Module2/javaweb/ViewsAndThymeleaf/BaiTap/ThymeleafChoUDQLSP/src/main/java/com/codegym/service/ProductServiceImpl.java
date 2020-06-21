package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    static Map<Integer, Product> products = new HashMap<>();

    static {
        products.put(1, new Product(1,
                "redmi 4x", 3200000, "https://cf.shopee.vn/file/84dd3f64f1d499e2ca7372ffa5b1f673"));
        products.put(2, new Product(2,
                "samsung j7", 5900000, "https://cdn.tgdd.vn/Products/Images/42/72198/samsung-galaxy-j7-1-400x533.png"));
    }

    @Override
    public void create(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }


    @Override
    public Product findByName(String name) {
        for (Map.Entry<Integer, Product> entry : products.entrySet()) {
            if (entry.getValue().getTenSanPham().equals(name)) {
                return products.get(entry.getKey());
            }
        }
        return null;
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
