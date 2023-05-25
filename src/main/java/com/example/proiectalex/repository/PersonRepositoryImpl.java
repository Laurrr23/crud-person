package com.example.proiectalex.repository;

import com.example.proiectalex.domain.Person;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@AllArgsConstructor
public class PersonRepositoryImpl implements PersonRepository{
    private MongoTemplate mongoTemplate;
    @Override
    public void save(final Person person) {
    this.mongoTemplate.save(person);
    }

    @Override
    public void deleteById(final String personId) {
        Query query = new Query();
        query.addCriteria(Criteria.where(personId).is("_id"));
        this.mongoTemplate.remove(query,Person.class);
    }

    @Override
    public List<Person> getAll() {
        return this.mongoTemplate.findAll(Person.class);
    }

    @Override
    public Person getById(String personId) {
       return this.mongoTemplate.findById(personId,Person.class);
    }
}
