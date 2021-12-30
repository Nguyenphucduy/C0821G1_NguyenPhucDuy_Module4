package librarybook.borrowbooks.controller;

import librarybook.borrowbooks.model.Book;
import librarybook.borrowbooks.model.CodeBook;
import librarybook.borrowbooks.service.IBookService;
import librarybook.borrowbooks.service.ICodeBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Random;

@Controller
public class BookController {
    @Autowired
    IBookService iBookService;
    @Autowired
    ICodeBookService iCodeBookService;

    @GetMapping("/")
    public String getList(Model model) {
        model.addAttribute("bookList", iBookService.findAll());
        System.err.println("đang lấy list");
        return "book/list";
    }

    @GetMapping("/borrow/{id}")
    public String borrow(@PathVariable(name = "id") Integer id, Model model, RedirectAttributes redirectAttributes) throws Exception {
        Book book = iBookService.findById(id);
        if (book.getQuantity() == 0) {
            throw new Exception();
        }
        book.setQuantity(book.getQuantity() - 1);
        iBookService.save(book);

        //--------------------------------------
        CodeBook codeBook = new CodeBook();
        int ramDom = (int) (Math.random() * 100000);
        codeBook.setCode(ramDom);
        codeBook.setId(book.getId());
        codeBook.setBook(book);
        iCodeBookService.save(codeBook);

        //-----------------------------------


        redirectAttributes.addFlashAttribute("msg", "Mã mượn sách của bạn là : " + codeBook.getCode());
        return "redirect:/";
    }

    @GetMapping("/back/{id}")
    public String giveBookBack(@PathVariable(name = "id") Integer id,Model model) {
        model.addAttribute("id",id);
        return "book/give-book-back";
    }

    @PostMapping("/give-book")
    public String giveBook(@RequestParam("id") Integer id, @RequestParam("code") int code, RedirectAttributes redirectAttributes) throws Exception {
        Book book = iBookService.findById(id);
        boolean check = false;



        for (CodeBook codeBook : iCodeBookService.findAll()) {
            if (code == codeBook.getCode() && book.getId().equals(codeBook.getBook().getId())) {
                iCodeBookService.delete(codeBook);
                check = true;
                break;
            }
        }
        if (!check) {
            throw new Exception();
        } else {
            book.setQuantity(book.getQuantity() + 1);
            iBookService.save(book);
            redirectAttributes.addFlashAttribute("msg", "trả sách thành công");
            return "redirect:/";
        }


    }

    @ExceptionHandler(Exception.class)
    public String handleException() {
        return "book/error";
    }
}
