/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bolaoservice.repositories.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.bm.bolaoservice.entity.Aposta;

/**
 *
 * @author Anderson
 */
public class ApostaDAO extends AbstractPersistence<Aposta, Long>{

    private EntityManager em;
    private static final Class<Aposta> entityClass = Aposta.class;
    
    public ApostaDAO(EntityManager em) {
        super(entityClass);
        this.em=em;
    }

    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }
    
    public List<Aposta> buscarPorUsuario(Long id){
        TypedQuery<Aposta> query = em.createNamedQuery("Aposta.findByUsuario", entityClass);
        query.setParameter("id", id);
        return query.getResultList();
    }
    
}
