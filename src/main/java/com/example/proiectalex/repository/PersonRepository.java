package com.example.proiectalex.repository;

import com.example.proiectalex.domain.Person;

import java.util.List;

public interface PersonRepository {
    void save(final Person person);
    void deleteById(final String personId);
    List<Person> getAll();
    Person getById(final String personId);
}
