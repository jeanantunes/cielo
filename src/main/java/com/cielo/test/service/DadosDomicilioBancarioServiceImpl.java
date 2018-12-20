package com.cielo.test.service;

import com.cielo.test.model.DadosDomicilioBancario;
import com.cielo.test.repository.DadosDomicilioBancarioReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DadosDomicilioBancarioServiceImpl implements DadosDomicilioBancarioService {

    @Autowired
    DadosDomicilioBancarioReposity dadosDomicilioBancarioRepository;

    @Override
    public DadosDomicilioBancario save(DadosDomicilioBancario dados) {
        dadosDomicilioBancarioRepository.update(dados);
        return dados;
    }

    @Override
    public DadosDomicilioBancario findById(Long id) {
        return dadosDomicilioBancarioRepository.findById(id);
    }

    @Override
    public String deleteById(Long id) {
        DadosDomicilioBancario dados = dadosDomicilioBancarioRepository.findById(id);
        if(dados != null){
            dadosDomicilioBancarioRepository.delete(dados);
            return "Excluido com Sucesso";
        }
        return "Dados null";
    }

    @Override
    public List<DadosDomicilioBancario> findAll() {
        return dadosDomicilioBancarioRepository.findAll();
    }

    @Override
    public List<DadosDomicilioBancario> findAll(Sort sort) {
        return null;
    }

    @Override
    public List<DadosDomicilioBancario> findAll(Iterable<Long> iterable) {
        return dadosDomicilioBancarioRepository.findAll();
    }

    @Override
    public <S extends DadosDomicilioBancario> List<S> save(Iterable<S> iterable) {
        return null;
    }

    @Override
    public DadosDomicilioBancario findOne(Long aLong) {
        return null;
    }

    @Override
    public boolean exists(Long aLong) {
        return false;
    }

    @Override
    public Page<DadosDomicilioBancario> findAll(Pageable pageable) {
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
    public <S extends DadosDomicilioBancario> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<DadosDomicilioBancario> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public DadosDomicilioBancario getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends DadosDomicilioBancario> S findOne(Example<S> example) {
        return null;
    }

    @Override
    public <S extends DadosDomicilioBancario> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends DadosDomicilioBancario> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends DadosDomicilioBancario> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends DadosDomicilioBancario> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends DadosDomicilioBancario> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(DadosDomicilioBancario DadosDomicilioBancario) {
        dadosDomicilioBancarioRepository.delete(DadosDomicilioBancario);
    }

    @Override
    public void delete(Iterable<? extends DadosDomicilioBancario> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}