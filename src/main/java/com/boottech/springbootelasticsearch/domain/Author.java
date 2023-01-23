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
@Document(indexName = "author")
public class Author {

    @Id
    private String id;

    @Field(type = FieldType.Text, name = "lastname")
    private String lastname;

    @Field(type = FieldType.Text, name = "middleName")
    private String middleName;

    @Field(type = FieldType.Text, name = "firstname")
    private String firstname;
}
