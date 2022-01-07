package blog_manager.blog.controller;

import blog_manager.blog.model.Blog;
import blog_manager.blog.model.Category;
import blog_manager.blog.service.IBlogService;
import blog_manager.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
public class CategoryRestController {

    @Autowired
    ICategoryService iCategoryService;


    //    Xem danh sách các category


    @GetMapping
    public ResponseEntity<List<Category>> findAllCategory() {
        List<Category> categories = iCategoryService.findAll();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

//    Xem danh sách các bài viết của một category

    @GetMapping("blog/{id}")
    public ResponseEntity<Set<Blog>> findAllCategoryBlog(@PathVariable Integer id) {
        Category category = iCategoryService.findById(id);
//        http://localhost:8080/blog/3
        Set<Blog> blogs =  category.getBlogs();

        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }


    // test thêm


    @GetMapping("/{id}")
    public ResponseEntity<Category> findCategoryById(@PathVariable Integer id) {
        Optional<Category> category = iCategoryService.getById(id);
        if (!category.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Category> saveCustomer(@RequestBody Category category) {
        iCategoryService.save(category);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }



    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCustomer(@PathVariable Integer id, @RequestBody Category customer) {
        Optional<Category> customerOptional = iCategoryService.getById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customer.setIdCategory(customerOptional.get().getIdCategory());
        iCategoryService.save(customer);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable Integer id) {
        Optional<Category> category = iCategoryService.getById(id);
        if (!category.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iCategoryService.remove(id);
        return new ResponseEntity<>(category.get(), HttpStatus.NO_CONTENT);
    }


}
