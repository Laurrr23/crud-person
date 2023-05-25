package com.example.proiectalex.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Document
@Getter
public class Person {
    @Id
    private String id;
    private String name;
    private int age;
    private String function;

public void update(final String name, final int age, final String function){
    this.name = name;
    this.age = age;
    this.function = function;
}
}
