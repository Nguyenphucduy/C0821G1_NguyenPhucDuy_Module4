package blog_manager.blog.service;

import blog_manager.blog.model.Blog;
import blog_manager.blog.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    void save(Category category);

    Category findById(Integer id);

    void remove(Integer id);
}
