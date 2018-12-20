package com.cielo.test.repository;

import com.cielo.test.model.TotalControleLancamento;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TotalControleLancamentoReposity {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(TotalControleLancamento totalControleLancamento) {
        entityManager.persist(totalControleLancamento);
        return;
    }

    public void delete(TotalControleLancamento totalControleLancamento) {
        if (entityManager.contains(totalControleLancamento))
            entityManager.remove(totalControleLancamento);
        else
            entityManager.remove(entityManager.merge(totalControleLancamento));
        return;
    }

    @SuppressWarnings("unchecked")
    public List findAll() {
        return entityManager.createQuery("from TotalControleLancamento").getResultList();
    }

    public TotalControleLancamento findById(Long id) {
        return entityManager.find(TotalControleLancamento.class, id);
    }

    public void update(TotalControleLancamento totalControleLancamento) {
        entityManager.merge(totalControleLancamento);
        return;
    }
}
