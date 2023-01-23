package com.boottech.springbootelasticsearch.service;


import com.boottech.springbootelasticsearch.domain.Book;

import java.util.List;

public interface BookService {
    List<Book> getAll();

    Book add(Book book);

    Book getById(String id);

    Book update(Book book, String id);

    void deleteById(String id);
}
