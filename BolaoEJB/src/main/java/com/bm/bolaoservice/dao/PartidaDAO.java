/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bolaoservice.dao;

import com.bm.bolaoservice.entity.Partida;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Anderson
 */
public class PartidaDAO extends AbstractPersistence<Partida, Long>{
    
    private EntityManager em;

    public PartidaDAO(EntityManager em) {
        super(Partida.class);
        this.em=em;
    }

    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }
    
    public List<Partida> buscarPorCampeonato(Long id){
        Query query = em.createNamedQuery("Partida.findByCampeonato");
        query.setParameter("idCampeonato", id);
        return query.getResultList();
    }
    
}
