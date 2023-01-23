package com.boottech.springbootelasticsearch.repository;

import com.boottech.springbootelasticsearch.domain.Author;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends ElasticsearchRepository<Author, String> {
}
