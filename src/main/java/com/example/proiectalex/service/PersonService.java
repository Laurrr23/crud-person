package com.example.proiectalex.service;

import com.example.proiectalex.domain.Person;
import com.example.proiectalex.dto.CreateUpdatePersonDto;
import com.example.proiectalex.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PersonService {
    private PersonRepository repo;

    public void save(final CreateUpdatePersonDto dto){
        Person person = new Person(UUID.randomUUID().toString(),
                dto.getName(),
                dto.getAge(),
                dto.getFunction());
        this.repo.save(person);
    }
    public void update(final String personId,final CreateUpdatePersonDto dto){
        Person person = this.repo.getById(personId);
        person.update(dto.getName(), dto.getAge(), dto.getFunction());
    }
    public List<Person> getAll(){
        return this.repo.getAll();
    }
    public void delete(final String personId){
        this.repo.deleteById(personId);
    }
}
