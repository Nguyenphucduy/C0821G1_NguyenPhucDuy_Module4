package product_manager.service.impl;

import org.springframework.stereotype.Service;
import product_manager.entity.Product;
import product_manager.service.IProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService implements IProductService {
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Iphone 4", 1000, "Iphone"));
        products.put(2, new Product(2, "Iphone 4s", 2000, "Iphone"));
        products.put(3, new Product(3, "Iphone 5", 3000, "Iphone"));
        products.put(4, new Product(4, "Iphone 5s", 4000, "Iphone"));
        products.put(5, new Product(5, "Iphone 6", 5000, "Iphone"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public Product search(String name) {
        Product product = null;
        for (Product product1 : findAll()){
            if (product1.getName().equals(name)){
                product = product1;
            }
        }
        return product;
    }
}
