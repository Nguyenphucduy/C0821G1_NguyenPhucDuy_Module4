package com.codegym.shoppingcart.controller;

import com.codegym.shoppingcart.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


@Controller
public class ShoppingCartController {

    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart (@SessionAttribute("cart") Cart cart,HttpSession session){


        System.out.println(((Cart) session.getAttribute("cart")).getProducts().size());

        ModelAndView modelAndView = new ModelAndView("/cart");

        System.out.println(((Cart) session.getAttribute("cart")).getProducts().size());

        modelAndView.addObject("cart",cart);

        return modelAndView;
    }

}