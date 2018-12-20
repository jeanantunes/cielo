package com.cielo.test.repository;

import com.cielo.test.model.ListaControleLancamento;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ListaControleLancamentoReposity {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(ListaControleLancamento listaControleLancamento) {
        entityManager.persist(listaControleLancamento);
        return;
    }

    public void delete(ListaControleLancamento listaControleLancamento) {
        if (entityManager.contains(listaControleLancamento))
            entityManager.remove(listaControleLancamento);
        else
            entityManager.remove(entityManager.merge(listaControleLancamento));
        return;
    }

    @SuppressWarnings("unchecked")
    public List findAll() {
        return entityManager.createQuery("from ListaControleLancamento").getResultList();
    }

    public ListaControleLancamento findById(Long id) {
        return entityManager.find(ListaControleLancamento.class, id);
    }

    public void update(ListaControleLancamento listaControleLancamento) {
        entityManager.merge(listaControleLancamento);
        return;
    }
}
