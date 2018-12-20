package com.cielo.test.service;

import com.cielo.test.model.TotalControleLancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TotalControleLancamentoService extends JpaRepository<TotalControleLancamento, Long> {

    TotalControleLancamento save(TotalControleLancamento dados);

    TotalControleLancamento findById(Long id);

    String deleteById(Long id);

    List<TotalControleLancamento> findAll();

    void delete(Long id);
}