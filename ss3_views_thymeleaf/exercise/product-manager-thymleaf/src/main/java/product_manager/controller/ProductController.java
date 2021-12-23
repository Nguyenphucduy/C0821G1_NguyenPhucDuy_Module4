package product_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import product_manager.entity.Product;
import product_manager.service.IProductService;

@Controller
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("products", productService.findAll());
        return "index";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("product") Product product, RedirectAttributes redirect) {
        product.setId((int)(Math.random() * 100));
        productService.save(product);
        redirect.addFlashAttribute("message", "Create product Done!");
        return "redirect:/";
    }
    @GetMapping("{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("product") Product product, RedirectAttributes redirect) {
        productService.update(product.getId(), product);
        redirect.addFlashAttribute("message", "Update Done");
        return "redirect:/";
    }
    @GetMapping("{id}/delete")
    public String delete(@PathVariable int id, Model model,RedirectAttributes redirect) {
        productService.remove(id);
        redirect.addFlashAttribute("message", "Delete Done");
        return "redirect:/";
    }
//
//
////    @PostMapping("/delete")
////    public String delete(@RequestParam("idProduct") int id, RedirectAttributes redirect) {
////        productService.remove(id);
////        redirect.addFlashAttribute("message", "Delete Done");
////        return "redirect:/";
////    }
//
    @GetMapping("{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "view";
    }
//    @PostMapping("/search")
//    public String search(@RequestParam("nameProduct") String name, Model model,RedirectAttributes redirect) {
//        model.addAttribute("product",productService.search(name));
//        if (productService.search(name)==null){
//            redirect.addFlashAttribute("message", "not found");
//            return "redirect:/";
//        }
//        return "view";
//    }
}
