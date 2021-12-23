package product_manager.repository;

import product_manager.entity.Product;

import java.util.List;

public interface IProductRepository {
    public List<Product> findAll();

    void save(Product product);

    Product findById(Integer id);

    void update(Integer id, Product product);

    void remove(Integer id);
}
