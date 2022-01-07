package blog_manager.blog.service;

import blog_manager.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {

    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(Integer id);

    void update(Blog blog);

    void remove(Integer id);

    Page<Blog> findAll(Pageable of);

    List<Blog> findByTopic(String topic);

    Optional<Blog> getById(Integer id);
}
