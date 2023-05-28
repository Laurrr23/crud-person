package com.example.proiectalex.service;

import com.example.proiectalex.domain.Person;
import com.example.proiectalex.domain.Produs;
import com.example.proiectalex.dto.CreateUpdatePersonDto;
import com.example.proiectalex.dto.CreateUpdateProdusDto;
import com.example.proiectalex.repository.ProdusRepository;
import com.example.proiectalex.repository.ProdusRepositoryImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor

public class ProdusService {
    private ProdusRepository repository;

    public void save(final CreateUpdateProdusDto dto){
        Produs produs = new Produs(UUID.randomUUID().toString(), dto.getName(), dto.getDescription());
        this.repository.save(produs);
    }
    public void deleteById(final String produsId){
        this.repository.deleteById(produsId);
    }
    public void update(final String produsId,final CreateUpdateProdusDto dto){
        Produs produsToUpdate = this.repository.findById(produsId);
        this.repository.save(produsToUpdate);
    }
    public List<Produs> getAll(){
        return this.repository.getAll();
    }
    public Produs findById(final String produsId){
        Produs produs = this.repository.findById(produsId);
        return produs;
    }
}
