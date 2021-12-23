package product_manager.repository;

import product_manager.entity.Product;

import java.util.List;

public interface IProductRepository {
    public List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void remove(int id);
}
