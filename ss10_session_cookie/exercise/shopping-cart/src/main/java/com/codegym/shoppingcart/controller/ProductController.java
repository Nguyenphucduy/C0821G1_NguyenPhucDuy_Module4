package com.codegym.shoppingcart.controller;

import com.codegym.shoppingcart.model.Cart;
import com.codegym.shoppingcart.model.Product;
import com.codegym.shoppingcart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute("cart") Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("cart") Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.updateProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }
    @GetMapping(value = "/info/{id}")
    public String getProductInfo(@PathVariable(name = "id") Long id, Model model) {

        Product product = productService.getById(id);

//        Optional<Product> productOptional = productService.findById(id);
        model.addAttribute("product",product);
        return "info";
    }
    @GetMapping("/payment")
    public String payment(@ModelAttribute("cart") Cart cart, HttpSession session){
        // tham chiếu đến đối tượng cart đó á, set lại Map trong cart đó là được

        cart.setProducts(new HashMap<>());

//        System.out.println(((Cart) session.getAttribute("cart")).getProducts().size());
//
//        session.setAttribute("cart",new Cart());
//
//        System.out.println(((Cart) session.getAttribute("cart")).getProducts().size());


        return "redirect:/shop";
    }
}