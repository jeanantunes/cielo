package com.cielo.test.service;

import com.cielo.test.model.LancamentoContaCorrenteCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LancamentoContaCorrenteClienteService extends JpaRepository<LancamentoContaCorrenteCliente, Long> {

    LancamentoContaCorrenteCliente save(LancamentoContaCorrenteCliente dados);

    LancamentoContaCorrenteCliente findById(Long id);

    String deleteById(Long id);

    List<LancamentoContaCorrenteCliente> findAll();

    void delete(Long id);
}