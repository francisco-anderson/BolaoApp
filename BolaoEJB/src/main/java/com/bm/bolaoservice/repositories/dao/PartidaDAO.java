/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bolaoservice.repositories.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.bm.bolaoservice.entity.Partida;

/**
 *
 * @author Anderson
 */
public class PartidaDAO extends AbstractPersistence<Partida, Long>{
    
    private EntityManager em;
    private static final Class<Partida> entityClass = Partida.class;

    public PartidaDAO(EntityManager em) {
        super(entityClass);
        this.em=em;
    }

    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }
    
    public List<Partida> buscarPorCampeonato(Long id){
        TypedQuery<Partida> query = em.createNamedQuery("Partida.findByCampeonato",entityClass);
        query.setParameter("idCampeonato", id);
        return query.getResultList();
    }
    
}
