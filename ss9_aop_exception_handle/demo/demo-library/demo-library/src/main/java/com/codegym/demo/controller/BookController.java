package com.codegym.demo.controller;

import com.codegym.demo.model.Book;
import com.codegym.demo.model.PersonalCode;
import com.codegym.demo.service.BookService;
import com.codegym.demo.service.PersonalCodeService;
import com.codegym.demo.util.CodeNotFoundException;
import com.codegym.demo.util.QuantityBookException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private PersonalCodeService personalCodeService;

    @GetMapping
    public String home() {
        return "home";
    }

    @GetMapping("/borrow")
    public ModelAndView showListBook() {
        return new ModelAndView("borrow", "books", bookService.findAll());
    }
    @GetMapping("/return-book")
    public ModelAndView showFormReturn() {
        return new ModelAndView("return", "personalCode", new PersonalCode());
    }

    @GetMapping("/borrow/{id}")
    public String borrowBook(@PathVariable Integer id, Model model) throws QuantityBookException {
        Book book = bookService.findById(id);
        Integer quantityBookOld = book.getQuantity();
        if (quantityBookOld == 0) {
            throw new QuantityBookException();
        }
        book.setQuantity(quantityBookOld - 1);
        bookService.save(book);
        int code = (int) (Math.random() * 89999 + 10000);
        String codeOfPerson = String.valueOf(code);
        model.addAttribute("code", codeOfPerson);
        PersonalCode personalCode = new PersonalCode(codeOfPerson, book);
        personalCodeService.save(personalCode);
        return "home";
    }

    @PostMapping("return-book")
    public String returnBook(@ModelAttribute PersonalCode personalCode, Model model) throws CodeNotFoundException {
        PersonalCode personalCodeNew = personalCodeService.findByCode(personalCode.getCodeForBook());
        if (personalCodeNew == null){
            throw new CodeNotFoundException();
        }
        Book book = personalCodeNew.getBook();
        Integer quantityBook = book.getQuantity();
        book.setQuantity(quantityBook+1);
        bookService.save(book);
        personalCodeService.delete(personalCodeNew.getId());
        model.addAttribute("msg", "Trả sách thành công");
        return "home";
    }

    @ExceptionHandler(QuantityBookException.class)
    public String showErrorQuantityPage(Model model) {
        model.addAttribute("error", "Sách đã hết");
        return "error";
    }

    @ExceptionHandler(CodeNotFoundException.class)
    public String showErrorNotFoundPage(Model model) {
        model.addAttribute("error", "Mã mượn sách không tồn tại");
        return "error";
    }
}
