package com.boottech.springbootelasticsearch.service.impl;

import com.boottech.springbootelasticsearch.domain.Author;
import com.boottech.springbootelasticsearch.exception.DataNotFoundException;
import com.boottech.springbootelasticsearch.repository.AuthorRepository;
import com.boottech.springbootelasticsearch.service.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Spliterators;
import java.util.stream.StreamSupport;

@Slf4j
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository repository;

    public AuthorServiceImpl(AuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Author> getAll() {
        return StreamSupport.stream(
                        Spliterators.spliteratorUnknownSize(repository.findAll().iterator(), 0), false)
                .toList();
    }

    @Override
    public Author add(Author author) {
        log.info("add author : {} " , author );
        return repository.save(author);
    }

    @Override
    public Author getById(String id) {
        return repository.findById(id).orElseThrow(() -> new DataNotFoundException("Author id not found"));
    }

    @Override
    public Author update(Author author, String id) {
        repository.findById(id)
                .ifPresentOrElse(author1 -> {
                    author1.setFirstname(author.getFirstname());
                    author1.setLastname(author.getLastname());
                    author1.setMiddleName(author.getMiddleName());
                    repository.save(author1);
                },() -> {throw new DataNotFoundException("Author id not found");});

        return author;
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
