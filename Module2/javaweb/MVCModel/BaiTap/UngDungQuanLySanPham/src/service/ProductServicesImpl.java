package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServicesImpl implements ProductService {
    private static Map<Integer, Product> product = new HashMap<>();

    static {
        product.put(1, new Product(1, "xiaomi redmi 4x", "3gb ram, 32gb rom",
                "3500000",
                "https://cdn.tgdd.vn/Products/Images/42/99145/xiaomi-redmi-4x-300-300x300.jpg"));
        product.put(2, new Product(2, "iphone 7s", "1,5gb ram, 32gb rom",
                "10900000",
                "https://cdn.tgdd.vn/Products/Images/42/78124/iphone-7-plus-32gb-gold-600x600-600x600.jpg"));
        product.put(3, new Product(3, "samsung galaxy fold", "6gb ram, 128gb rom",
                "50000000",
                "https://cdn.tgdd.vn/Products/Images/42/198158/samsung-galaxy-fold-black-400x400.jpg"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(product.values());
    }

    @Override
    public void save(Product products) {
        product.put(products.getId(), products);
    }

    @Override
    public Product findById(int id) {
        return product.get(id);
    }

    @Override
    public void update(int id, Product products) {
        product.put(id, products);
    }

    @Override
    public void remove(int id) {
        product.remove(id);
    }
    @Override
    public Product findByName(String name) {
        for (Map.Entry<Integer, Product> entry : product.entrySet()) {
            if (entry.getValue().getNameProduct().equals(name)) {
                return entry.getValue();
            }
        }
        return null;
    }
}
