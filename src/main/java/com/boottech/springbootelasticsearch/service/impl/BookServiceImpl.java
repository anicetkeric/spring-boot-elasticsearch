package com.boottech.springbootelasticsearch.service.impl;

import com.boottech.springbootelasticsearch.domain.Book;
import com.boottech.springbootelasticsearch.exception.DataNotFoundException;
import com.boottech.springbootelasticsearch.repository.BookRepository;
import com.boottech.springbootelasticsearch.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Book> getAll() {
        return StreamSupport.stream(
                        Spliterators.spliteratorUnknownSize(repository.findAll().iterator(), 0), false)
                .toList();
    }

    @Override
    public Book add(Book book) {
        log.info("addBook : {} " , book );
        return repository.save(book);
    }

    @Override
    public Book getById(String id) {
        return repository.findById(id).orElseThrow(() -> new DataNotFoundException("Book id not found"));
    }

    @Override
    public Book update(Book book, String id) {
         repository.findById(id)
                .ifPresentOrElse(book1 -> {
                    book1.setTitle(book.getTitle());
                    book1.setIsbn(book.getIsbn());
                    book1.setDescription(book.getDescription());
                    book1.setLanguage(book.getLanguage());
                    book1.setPage(book.getPage());
                    book1.setPrice(book.getPrice());
                    repository.save(book1);
                },() -> {throw new DataNotFoundException("Book id not found");});

        return book;
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
