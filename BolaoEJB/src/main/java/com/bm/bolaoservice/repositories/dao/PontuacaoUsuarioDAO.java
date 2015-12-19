/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bolaoservice.repositories.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.bm.bolaoservice.entity.PontuacaoUsuario;

/**
 *
 * @author Anderson
 */
public class PontuacaoUsuarioDAO extends AbstractPersistence<PontuacaoUsuario, Long>{
    
    private EntityManager em;
    private static final Class<PontuacaoUsuario> entityClass = PontuacaoUsuario.class;

    public PontuacaoUsuarioDAO(EntityManager em) {
        super(entityClass);
        this.em=em;
    }

    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }
    
    public List<PontuacaoUsuario> buscarPorUsuario (Long id){
        TypedQuery<PontuacaoUsuario> query =  em.createNamedQuery("PontuacaoUsuario.findByUsuario",entityClass);
        query.setParameter("idUsuario", id);
        return query.getResultList();
    }
    
    public List<PontuacaoUsuario> buscarPorCampeonato (Long id){
        TypedQuery<PontuacaoUsuario> query = em.createNamedQuery("PontuacaoUsuario.findByCampeonato",entityClass);
        query.setParameter("idCampeonato", id);
        return query.getResultList();
    }
    
}
