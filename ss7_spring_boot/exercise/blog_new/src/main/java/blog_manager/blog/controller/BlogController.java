package blog_manager.blog.controller;

import blog_manager.blog.model.Blog;
import blog_manager.blog.service.IBlogService;
import blog_manager.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/blog")
@Controller
public class BlogController {
    @Autowired
    IBlogService iBlogService;

    @Autowired
    ICategoryService iCategoryService;

    @GetMapping("/")
    public String listPageable(Model model, @RequestParam(value = "page", defaultValue = "0")int page) {
        // ten column trong DB
        Sort sort = Sort.by("id").and(Sort.by("topic")).descending();

        //PageRequest la class impl Pageable
        Page<Blog> blogPage = iBlogService.findAll(PageRequest.of(page,2,sort));
        model.addAttribute("blogPage", blogPage);
        return "blog/list";
    }
    @PostMapping("/search")
    public ModelAndView search(@RequestParam(value = "topic", defaultValue = "")String topic) {
        return new ModelAndView("blog/list_search","blogPage", iBlogService.findByTopic(topic));
    }


    @GetMapping("/create")
    public String getPageCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList", iCategoryService.findAll());
        return "blog/create";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("messenger", "Create blog successfully!");
        return "redirect:/blog/";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("categoryList", iCategoryService.findAll());
        model.addAttribute("blog", iBlogService.findById(id));
        return "blog/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("blog") Blog blog, RedirectAttributes redirect) {
        iBlogService.update(blog);
        redirect.addFlashAttribute("messenger", "Update Done");
        return "redirect:/blog/";
    }

    @GetMapping("{id}/view")
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "blog/view";
    }

    @GetMapping("{id}/delete")
    public String delete(@PathVariable Integer id, Model model, RedirectAttributes redirect) {
        iBlogService.remove(id);
        redirect.addFlashAttribute("messenger", "Delete Done");
        return "redirect:/blog/";
    }
}
