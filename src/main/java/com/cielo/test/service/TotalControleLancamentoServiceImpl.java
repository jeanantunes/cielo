package com.cielo.test.service;

import com.cielo.test.model.TotalControleLancamento;
import com.cielo.test.repository.TotalControleLancamentoReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TotalControleLancamentoServiceImpl implements TotalControleLancamentoService {

    @Autowired
    TotalControleLancamentoReposity totalControleLancamentoRepository;

    @Override
    public TotalControleLancamento save(TotalControleLancamento dados) {
        totalControleLancamentoRepository.update(dados);
        return dados;
    }

    @Override
    public TotalControleLancamento findById(Long id) {
        return totalControleLancamentoRepository.findById(id);
    }

    @Override
    public String deleteById(Long id) {
        TotalControleLancamento dados = totalControleLancamentoRepository.findById(id);
        if(dados != null){
            totalControleLancamentoRepository.delete(dados);
            return "Excluido com Sucesso";
        }
        return "Dados null";
    }

    @Override
    public List<TotalControleLancamento> findAll() {
        return totalControleLancamentoRepository.findAll();
    }

    @Override
    public List<TotalControleLancamento> findAll(Sort sort) {
        return null;
    }

    @Override
    public List<TotalControleLancamento> findAll(Iterable<Long> iterable) {
        return totalControleLancamentoRepository.findAll();
    }

    @Override
    public <S extends TotalControleLancamento> List<S> save(Iterable<S> iterable) {
        return null;
    }

    @Override
    public TotalControleLancamento findOne(Long aLong) {
        return null;
    }

    @Override
    public boolean exists(Long aLong) {
        return false;
    }

    @Override
    public Page<TotalControleLancamento> findAll(Pageable pageable) {
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
    public <S extends TotalControleLancamento> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<TotalControleLancamento> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public TotalControleLancamento getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends TotalControleLancamento> S findOne(Example<S> example) {
        return null;
    }

    @Override
    public <S extends TotalControleLancamento> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends TotalControleLancamento> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends TotalControleLancamento> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends TotalControleLancamento> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends TotalControleLancamento> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(TotalControleLancamento TotalControleLancamento) {
        totalControleLancamentoRepository.delete(TotalControleLancamento);
    }

    @Override
    public void delete(Iterable<? extends TotalControleLancamento> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}