package com.example.proiectalex.repository;

import com.example.proiectalex.domain.Produs;

import java.util.List;

public interface ProdusRepository {
    void save (final Produs produs);
    void deleteById(final String produsId);
    List<Produs> getAll();
    Produs findById(final String produsId);
}
