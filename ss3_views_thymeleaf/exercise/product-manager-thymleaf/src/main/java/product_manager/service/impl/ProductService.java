package product_manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import product_manager.entity.Product;
import product_manager.service.IProductService;
import product_manager.repository.impl.ProductRepository;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    ProductRepository productRepository;



    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public void update(Integer id, Product product) {
      productRepository.update(id,product);
    }

    @Override
    public void remove(Integer id) {
        productRepository.remove(id);
    }
//
//    @Override
//    public Product search(String name) {
//        Product product = null;
//        for (Product product1 : findAll()){
//            if (product1.getName().equals(name)){
//                product = product1;
//            }
//        }
//        return product;
//    }
}
