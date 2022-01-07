package blog_manager.blog.controller;


import blog_manager.blog.model.Blog;
import blog_manager.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blog")
@CrossOrigin(origins = "*")
public class BlogRestController {
    @Autowired
    private IBlogService iBlogService;
// Chỉ rõ kiểu dữ liệu gửi đi và nhận vào
//    Produces: dịnh dạng dữ liệu trả về cho Client(Accept)
//    Consumes: quy định loại nội dung của request (Content-Type [mặc định là content - all-type])
//    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)

    @GetMapping(value = "")
    public ResponseEntity<List<Blog>> showList(@RequestParam(name = "topic", required = false) String topic,
                                               @RequestParam(name = "index", required = false) Integer index) {
        List<Blog> blogList = iBlogService.searchByTopic(topic, index);
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }



        @PostMapping("/create-blog")
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) {
        iBlogService.save(blog);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
//    Xem chi tiết một bài viết


    @GetMapping("/rest-blogs/{id}")
    public ResponseEntity<Blog> findBlogById(@PathVariable Integer id) {
        Optional<Blog> blog = iBlogService.getById(id);
        if (!blog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog.get(), HttpStatus.OK);
    }

    //    Xem danh sách các bài viết

    @GetMapping("/rest-blogs")
    public ResponseEntity<List<Blog>> findAllBlog() {
        List<Blog> blogs = iBlogService.findAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

}
