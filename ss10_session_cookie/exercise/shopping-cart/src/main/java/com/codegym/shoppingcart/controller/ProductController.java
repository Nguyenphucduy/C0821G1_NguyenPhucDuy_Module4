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

//    @GetMapping("/go_quantity/{id}")
//    public String goQuantityToCart(@PathVariable Long id, @ModelAttribute("cart") Cart cart, @RequestParam("action") String action,Model model) {
//        model.addAttribute("cart",cart);
//        model.addAttribute("id",id);
//        model.addAttribute("action",action);
//        return "quantity";
//    }


    @PostMapping("/quantity")
    public String quantityToCart(@RequestParam("id") Long id, @ModelAttribute("cart") Cart cart, @RequestParam("action") String action,@RequestParam("quantity") Integer quantity) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.quantityProduct(productOptional.get(),quantity);
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

//        Product product = productService.getById(id);
//Optional là kiểu đối tượng có thì lấy giá mà không có cũng lấy giá trì( trả về null)

        Optional<Product> product = productService.findById(id);
        if (!product.isPresent()) {
            return "/error.404";
        }
        model.addAttribute("product",product.get());
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