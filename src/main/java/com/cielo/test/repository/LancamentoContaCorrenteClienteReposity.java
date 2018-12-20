package com.cielo.test.repository;

import com.cielo.test.model.LancamentoContaCorrenteCliente;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class LancamentoContaCorrenteClienteReposity {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(LancamentoContaCorrenteCliente lancamentoCCCliente) {
        entityManager.persist(lancamentoCCCliente);
        return;
    }

    public void delete(LancamentoContaCorrenteCliente lancamentoCCCliente) {
        if (entityManager.contains(lancamentoCCCliente))
            entityManager.remove(lancamentoCCCliente);
        else
            entityManager.remove(entityManager.merge(lancamentoCCCliente));
        return;
    }

    @SuppressWarnings("unchecked")
    public List findAll() {
        return entityManager.createQuery("from LancamentoContaCorrenteCliente").getResultList();
    }

    public LancamentoContaCorrenteCliente findById(Long id) {
        return entityManager.find(LancamentoContaCorrenteCliente.class, id);
    }

    public void update(LancamentoContaCorrenteCliente lancamentoCCCliente) {
        entityManager.merge(lancamentoCCCliente);
        return;
    }
}
