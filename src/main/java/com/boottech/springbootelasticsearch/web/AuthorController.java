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
    public List<Author> getAllAuthors() {
        return authorService.getAll();
    }

/*
    @GetMapping("/author/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable("id") String id) {

        return authorService.getById(id)
            .map(author1 -> ResponseEntity.ok()
                .body(author1))
            .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()))
            .log();
    }
*/

    @PostMapping("/author")
    @ResponseStatus(HttpStatus.CREATED)
    public Author addAuthor(@RequestBody @Valid Author author) {
        return authorService.add(author);

    }

/*
    @PutMapping("/author/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ResponseEntity<Author>> updateAuthor(@RequestBody Author author, @PathVariable String id) {

        var updatedAuthorMono =  authorService.update(author, id);
        return updatedAuthorMono
            .map(author1 -> ResponseEntity.ok()
                .body(author1))
            .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }
*/

    @DeleteMapping("/author/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteAuthorById(@PathVariable String id){
         authorService.deleteById(id);

        return ResponseEntity.ok().body("Done");
    }

}
