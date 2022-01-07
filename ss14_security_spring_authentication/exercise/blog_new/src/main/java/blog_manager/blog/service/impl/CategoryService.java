package blog_manager.blog.service.impl;

import blog_manager.blog.model.Category;
import blog_manager.blog.repository.IBlogRepository;
import blog_manager.blog.repository.ICategoryRepository;
import blog_manager.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepository iCategoryRepository;
    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public Category findById(Integer id) {
        return iCategoryRepository.findById(id).orElse(null);
    }


    @Override
    public void remove(Integer id) {
        iCategoryRepository.deleteById(id);
    }

    @Override
    public Optional<Category> getById(Integer id) {
        return iCategoryRepository.findById(id);
    }
}
