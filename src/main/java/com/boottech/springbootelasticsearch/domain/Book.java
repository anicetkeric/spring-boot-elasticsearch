package com.boottech.springbootelasticsearch.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(indexName = "book")
public class Book {
    @Id
    private String id;

    @Field(type = FieldType.Text, name = "title")
    private String title;

    @Field(type = FieldType.Integer, name = "page")
    private Integer page;

    @Field(type = FieldType.Text, name = "title")
    private String isbn;

    @Field(type = FieldType.Text, name = "title")
    private String description;

    @Field(type = FieldType.Text, name = "title")
    private String language;

   // private LocalDate publication;

    @Field(type = FieldType.Double, name = "price")
    private Double price;
}
