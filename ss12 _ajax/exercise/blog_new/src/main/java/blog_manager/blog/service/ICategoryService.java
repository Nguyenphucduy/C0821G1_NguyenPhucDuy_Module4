package blog_manager.blog.service;

import blog_manager.blog.model.Blog;
import blog_manager.blog.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> findAll();
    void save(Category category);

    Category findById(Integer id);

    void remove(Integer id);

    Optional<Category> getById(Integer id);
}
