/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bolaoservice.dao;

import com.bm.bolaoservice.entity.PontuacaoUsuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Anderson
 */
public class PontuacaoUsuarioDAO extends AbstractPersistence<PontuacaoUsuario, Long>{
    
    private EntityManager em;

    public PontuacaoUsuarioDAO(EntityManager em) {
        super(PontuacaoUsuario.class);
        this.em=em;
    }

    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }
    
    public List<PontuacaoUsuario> buscarPorUsuario (Long id){
        Query query =  em.createNamedQuery("PontuacaoUsuario.findByUsuario");
        query.setParameter("idUsuario", id);
        return query.getResultList();
    }
    
    public List<PontuacaoUsuario> buscarPorCampeonato (Long id){
        Query query = em.createNamedQuery("PontuacaoUsuario.findByCampeonato");
        query.setParameter("idCampeonato", id);
        return query.getResultList();
    }
    
}
