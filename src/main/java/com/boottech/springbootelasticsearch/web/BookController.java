package com.boottech.springbootelasticsearch.web;

import com.boottech.springbootelasticsearch.domain.Book;
import com.boottech.springbootelasticsearch.service.BookService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book")
    public List<Book> getAllBooks() {
        return bookService.getAll();
    }

/*    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") String id) {

        return bookService.getById(id)
            .map(book1 -> ResponseEntity.ok()
                .body(book1))
            .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()))
            .log();
    }*/

    @PostMapping("/book")
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody @Valid Book book) {
        return bookService.add(book);

    }

/*    @PutMapping("/book/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ResponseEntity<Book>> updateBook(@RequestBody Book book, @PathVariable String id) {

        var updatedBookMono =  bookService.update(book, id);
        return updatedBookMono
            .map(book1 -> ResponseEntity.ok()
                .body(book1))
            .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }*/

    @DeleteMapping("/book/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteBookById(@PathVariable String id){
        bookService.deleteById(id);

        return ResponseEntity.ok().body("Done");
    }

}
