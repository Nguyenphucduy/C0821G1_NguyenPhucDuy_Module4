package blog_manager.blog.service.impl;

import blog_manager.blog.model.Blog;
import blog_manager.blog.repository.IBlogRepository;
import blog_manager.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
       iBlogRepository.save(blog);
    }

    @Override
    public Blog findById(Integer id) {
      return   iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Blog blog) {
        // có id rồi thì tự update
        iBlogRepository.save(blog);
    }

    @Override
    public void remove(Integer id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findAll(Pageable of) {
        return iBlogRepository.findAll(of);
    }

    @Override
    public List<Blog> findByTopic(String topic) {
        return iBlogRepository.getByTopic("%"+topic+"%");
    }
}
