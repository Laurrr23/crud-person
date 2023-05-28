package com.example.proiectalex.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@Getter
public class Produs {
    @Id
    private String id;
    private String name;
    private String description;
}
