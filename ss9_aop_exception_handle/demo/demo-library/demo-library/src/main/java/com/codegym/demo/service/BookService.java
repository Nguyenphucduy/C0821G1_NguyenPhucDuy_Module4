package com.codegym.demo.service;


import com.codegym.demo.model.Book;

import java.util.List;

public interface BookService {
    void save(Book book);
    void deleteById(Integer id);
    Book findById(Integer id);
    List<Book> findAll();
}
