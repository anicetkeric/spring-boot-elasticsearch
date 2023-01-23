package com.boottech.springbootelasticsearch.repository;

import com.boottech.springbootelasticsearch.domain.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends ElasticsearchRepository<Book, String> {
}
