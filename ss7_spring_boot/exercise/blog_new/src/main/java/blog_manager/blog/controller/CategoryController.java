package blog_manager.blog.controller;

import blog_manager.blog.model.Category;
import blog_manager.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@RequestMapping(value = "/category")
@Controller
public class CategoryController {
    @Autowired
    ICategoryService iCategoryService;
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
    public String createStudent(@ModelAttribute("category")Category category, RedirectAttributes redirectAttributes) {
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
    @GetMapping("{id}/delete")
    public String delete(@PathVariable Integer id,RedirectAttributes redirect) {
        iCategoryService.remove(id);
        redirect.addFlashAttribute("messenger", "Delete Done");
        return "redirect:/category/list";
    }
}
