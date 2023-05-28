package com.example.proiectalex.repository;

import com.example.proiectalex.domain.Produs;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@AllArgsConstructor
public  class ProdusRepositoryImpl implements ProdusRepository {
    private MongoTemplate mongoTemplate;

    @Override
    public void save(final Produs produs) {
        this.mongoTemplate.save(produs);
    }

    @Override
    public void deleteById(final String produsId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(produsId));
        this.mongoTemplate.remove(query,Produs.class);
    }

    @Override
    public List<Produs> getAll() {
return this.mongoTemplate.findAll(Produs.class);
    }

    @Override
    public Produs findById(final String produsId) {
        return this.mongoTemplate.findById(produsId,Produs.class);
    }
}
