package com.cielo.test.repository;

import com.cielo.test.model.DadosDomicilioBancario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class DadosDomicilioBancarioReposity {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(DadosDomicilioBancario domicilioBancario) {
        entityManager.persist(domicilioBancario);
        return;
    }

    public void delete(DadosDomicilioBancario domicilioBancario) {
        if (entityManager.contains(domicilioBancario))
            entityManager.remove(domicilioBancario);
        else
            entityManager.remove(entityManager.merge(domicilioBancario));
        return;
    }

    @SuppressWarnings("unchecked")
    public List findAll() {
        return entityManager.createQuery("from DadosDomicilioBancario").getResultList();
    }

    public DadosDomicilioBancario findById(Long id) {
        return entityManager.find(DadosDomicilioBancario.class, id);
    }

    public void update(DadosDomicilioBancario domicilioBancario) {
        entityManager.merge(domicilioBancario);
        return;
    }
}
