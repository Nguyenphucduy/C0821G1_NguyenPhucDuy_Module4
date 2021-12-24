package blog.controller;

import blog.model.Blog;
import blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class BlogController {
 @Autowired
    IBlogService iBlogService;


    @GetMapping("/")
    public String getList(Model model){
        model.addAttribute("blogList", iBlogService.findAll());
        return "list";
    }
    @GetMapping("/create")
    public String getPageCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping(value = "/create")
    public String createStudent(@ModelAttribute("blog")Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("messenger", "Create blog successfully!");
        return "redirect:/";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("blog") Blog blog, RedirectAttributes redirect) {
        iBlogService.update(blog);
        redirect.addFlashAttribute("messenger", "Update Done");
        return "redirect:/";
    }
    @GetMapping("{id}/view")
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "view";
    }
    @GetMapping("{id}/delete")
    public String delete(@PathVariable Integer id, Model model,RedirectAttributes redirect) {
        iBlogService.remove(id);
        redirect.addFlashAttribute("messenger", "Delete Done");
        return "redirect:/";
    }
}
