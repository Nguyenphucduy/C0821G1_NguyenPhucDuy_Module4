package product_manager.repository.impl;

import org.springframework.stereotype.Repository;
import product_manager.entity.Product;
import product_manager.repository.IProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Product> findAll() {
        //        HQL
        return BaseRepository.entityManager
                .createQuery("select p from product p ", Product.class)
                .getResultList();
    }

    @Override
    public void save(Product product) {
        if (product.getId() != null) {
            em.merge(product);
        } else {
            em.persist(product);
        }
    }

    @Override
    public Product findById(Integer id) {
        return BaseRepository.entityManager.find(Product.class, id);
    }

    @Override
    public void update(Integer id, Product product) {
        if (product.getId() != null) {
            em.merge(product);
        } else {
            em.persist(product);
        }
    }

    @Override
    public void remove(Integer id) {
        Product product = findById(id);
        if (product != null) {
            em.remove(product);
        }
    }
}
