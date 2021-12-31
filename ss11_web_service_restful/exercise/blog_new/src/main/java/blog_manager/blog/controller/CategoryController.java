package blog_manager.blog.controller;

import blog_manager.blog.model.Blog;
import blog_manager.blog.model.Category;
import blog_manager.blog.service.IBlogService;
import blog_manager.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@Controller
@RequestMapping(value = "/category")
public class CategoryController {
    @Autowired
    ICategoryService iCategoryService;

    @Autowired
    IBlogService iBlogService;

    @GetMapping(value = "/list")
    public String getList(Model model){
        model.addAttribute("categoryList",iCategoryService.findAll());
        return "/category/list";
    }
    @GetMapping("/create")
    public String getPageCreate(Model model) {
        model.addAttribute("category", new Category());
        return "category/create";
    }

    @PostMapping(value = "/create")
    public String createCategory(@ModelAttribute("category")Category category, RedirectAttributes redirectAttributes) {
        iCategoryService.save(category);
        redirectAttributes.addFlashAttribute("messenger", "Create category successfully!");
        return "redirect:/category/list";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("category", iCategoryService.findById(id));
        return "category/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("category") Category category, RedirectAttributes redirect) {
        iCategoryService.save(category);
        redirect.addFlashAttribute("messenger", "Update Done");
        return "redirect:/category/list";
    }
    @GetMapping("{id}/view")
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("category", iCategoryService.findById(id));
        return "category/view";
    }
    @GetMapping ("{id}/delete")
    public String delete(@PathVariable Integer id,RedirectAttributes redirect) {
        iCategoryService.remove(id);
        redirect.addFlashAttribute("messenger", "Delete Done");
        return "redirect:/category/list";
    }



}
