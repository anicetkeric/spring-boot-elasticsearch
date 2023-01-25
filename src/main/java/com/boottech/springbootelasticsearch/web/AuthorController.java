package com.boottech.springbootelasticsearch.web;

import com.boottech.springbootelasticsearch.domain.Author;
import com.boottech.springbootelasticsearch.service.AuthorService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/author")
    public ResponseEntity<List<Author>> getAllAuthors() {
        return ResponseEntity.ok().body(authorService.getAll());
    }

    @PostMapping("/author")
    @ResponseStatus(HttpStatus.CREATED)
    public Author addAuthor(@RequestBody @Valid Author author) {
        return authorService.add(author);

    }

    @DeleteMapping("/author/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteAuthorById(@PathVariable String id){
        authorService.deleteById(id);

        return ResponseEntity.ok().body("Done");
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(authorService.getById(id));
    }


    @PutMapping("/author/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Author> updateAuthor(@RequestBody Author author, @PathVariable String id) {
        var updatedAuthor =  authorService.update(author, id);
        return ResponseEntity.ok().body(updatedAuthor);

    }
}
