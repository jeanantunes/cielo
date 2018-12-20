package com.cielo.test.service;

import com.cielo.test.model.LancamentoContaCorrenteCliente;
import com.cielo.test.repository.LancamentoContaCorrenteClienteReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LancamentoContaCorrenteClienteServiceImpl implements LancamentoContaCorrenteClienteService {

    @Autowired
    LancamentoContaCorrenteClienteReposity lancamentoContaCorrenteClienteRepository;

    @Override
    public LancamentoContaCorrenteCliente save(LancamentoContaCorrenteCliente dados) {
        lancamentoContaCorrenteClienteRepository.update(dados);
        return dados;
    }

    @Override
    public LancamentoContaCorrenteCliente findById(Long id) {
        return lancamentoContaCorrenteClienteRepository.findById(id);
    }

    @Override
    public String deleteById(Long id) {
        LancamentoContaCorrenteCliente dados = lancamentoContaCorrenteClienteRepository.findById(id);
        if(dados != null){
            lancamentoContaCorrenteClienteRepository.delete(dados);
            return "Excluido com Sucesso";
        }
        return "Dados null";
    }

    @Override
    public List<LancamentoContaCorrenteCliente> findAll() {
        return lancamentoContaCorrenteClienteRepository.findAll();
    }

    @Override
    public List<LancamentoContaCorrenteCliente> findAll(Sort sort) {
        return null;
    }

    @Override
    public List<LancamentoContaCorrenteCliente> findAll(Iterable<Long> iterable) {
        return lancamentoContaCorrenteClienteRepository.findAll();
    }

    @Override
    public <S extends LancamentoContaCorrenteCliente> List<S> save(Iterable<S> iterable) {
        return null;
    }

    @Override
    public LancamentoContaCorrenteCliente findOne(Long aLong) {
        return null;
    }

    @Override
    public boolean exists(Long aLong) {
        return false;
    }

    @Override
    public Page<LancamentoContaCorrenteCliente> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends LancamentoContaCorrenteCliente> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<LancamentoContaCorrenteCliente> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public LancamentoContaCorrenteCliente getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends LancamentoContaCorrenteCliente> S findOne(Example<S> example) {
        return null;
    }

    @Override
    public <S extends LancamentoContaCorrenteCliente> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends LancamentoContaCorrenteCliente> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends LancamentoContaCorrenteCliente> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends LancamentoContaCorrenteCliente> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends LancamentoContaCorrenteCliente> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(LancamentoContaCorrenteCliente LancamentoContaCorrenteCliente) {
        lancamentoContaCorrenteClienteRepository.delete(LancamentoContaCorrenteCliente);
    }

    @Override
    public void delete(Iterable<? extends LancamentoContaCorrenteCliente> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}