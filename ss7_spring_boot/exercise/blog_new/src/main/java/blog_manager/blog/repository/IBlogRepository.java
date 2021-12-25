package blog_manager.blog.repository;

import blog_manager.blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "select * from blog where topic like :topic",nativeQuery = true)
    List<Blog> getByTopic(@Param("topic") String topic);
}
