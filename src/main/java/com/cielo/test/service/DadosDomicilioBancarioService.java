package com.cielo.test.service;

import com.cielo.test.model.DadosDomicilioBancario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DadosDomicilioBancarioService extends JpaRepository<DadosDomicilioBancario, Long> {

    DadosDomicilioBancario save(DadosDomicilioBancario dados);

    DadosDomicilioBancario findById(Long id);

    String deleteById(Long id);

    List<DadosDomicilioBancario> findAll();

    void delete(Long id);
}