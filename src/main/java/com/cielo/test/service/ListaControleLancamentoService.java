package com.cielo.test.service;

import com.cielo.test.model.ListaControleLancamento;
import com.cielo.test.model.ListaControleLancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ListaControleLancamentoService extends JpaRepository<ListaControleLancamento, Long> {

    ListaControleLancamento save(ListaControleLancamento lista);

    ListaControleLancamento findById(Long id);

    String deleteById(Long id);

    List<ListaControleLancamento> findAll();

    void delete(Long id);
}