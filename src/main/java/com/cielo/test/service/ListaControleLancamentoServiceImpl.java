package com.cielo.test.service;

import com.cielo.test.model.ListaControleLancamento;
import com.cielo.test.repository.ListaControleLancamentoReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaControleLancamentoServiceImpl implements ListaControleLancamentoService {

    @Autowired
    ListaControleLancamentoReposity lancamentoContaCorrenteClienteRepository;

    @Override
    public ListaControleLancamento save(ListaControleLancamento dados) {
        lancamentoContaCorrenteClienteRepository.update(dados);
        return dados;
    }

    @Override
    public ListaControleLancamento findById(Long id) {
        return lancamentoContaCorrenteClienteRepository.findById(id);
    }

    @Override
    public String deleteById(Long id) {
        ListaControleLancamento dados = lancamentoContaCorrenteClienteRepository.findById(id);
        if(dados != null){
            lancamentoContaCorrenteClienteRepository.delete(dados);
            return "Excluido com Sucesso";
        }
        return "Dados null";
    }

    @Override
    public List<ListaControleLancamento> findAll() {
        return lancamentoContaCorrenteClienteRepository.findAll();
    }

    @Override
    public List<ListaControleLancamento> findAll(Sort sort) {
        return null;
    }

    @Override
    public List<ListaControleLancamento> findAll(Iterable<Long> iterable) {
        return lancamentoContaCorrenteClienteRepository.findAll();
    }

    @Override
    public <S extends ListaControleLancamento> List<S> save(Iterable<S> iterable) {
        return null;
    }

    @Override
    public ListaControleLancamento findOne(Long aLong) {
        return null;
    }

    @Override
    public boolean exists(Long aLong) {
        return false;
    }

    @Override
    public Page<ListaControleLancamento> findAll(Pageable pageable) {
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
    public <S extends ListaControleLancamento> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<ListaControleLancamento> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public ListaControleLancamento getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends ListaControleLancamento> S findOne(Example<S> example) {
        return null;
    }

    @Override
    public <S extends ListaControleLancamento> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends ListaControleLancamento> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends ListaControleLancamento> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ListaControleLancamento> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends ListaControleLancamento> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(ListaControleLancamento ListaControleLancamento) {
        lancamentoContaCorrenteClienteRepository.delete(ListaControleLancamento);
    }

    @Override
    public void delete(Iterable<? extends ListaControleLancamento> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}