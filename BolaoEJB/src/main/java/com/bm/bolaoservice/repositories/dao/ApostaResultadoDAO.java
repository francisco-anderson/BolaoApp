/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bolaoservice.repositories.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.bm.bolaoservice.entity.ApostaResultado;

/**
 *
 * @author Anderson
 */
public class ApostaResultadoDAO extends AbstractPersistence<ApostaResultado, Long>{
    
    private EntityManager em;
    private static final Class<ApostaResultado> entityClass = ApostaResultado.class;
    
    public ApostaResultadoDAO(EntityManager em){
        super(entityClass);
        this.em=em;
    }
      
    
  
    
    public List<ApostaResultado> buscarPorAposta(Long id){
        TypedQuery<ApostaResultado> query = em.createNamedQuery("ApostaResultado.findByIdAposta",entityClass);
        query.setParameter("idAposta", id);
        return query.getResultList();
    }
    
    public List<ApostaResultado> buscarPorEquipe(Long id){
        TypedQuery<ApostaResultado> query = em.createNamedQuery("ApostaResultado.findByIdEquipe",entityClass);
        query.setParameter("idEquipe", id);
        return query.getResultList();
    }
    
    public List<ApostaResultado> buscarPorPartida(Long id){
        TypedQuery<ApostaResultado> query = em.createNamedQuery("ApostaResultado.findByIdPartida",entityClass);
        query.setParameter("idPartida", id);
        return query.getResultList();
    }
    
    public List<ApostaResultado> buscarPorEquipePartida(Long idEquipe,Long idPartida){
        TypedQuery<ApostaResultado> query = em.createNamedQuery("ApostaResultado.findByIdEquipeAndPartida",entityClass);
        query.setParameter("idEquipe", idEquipe);
        query.setParameter("idPartida", idPartida);
        return query.getResultList();
    }
    
    public ApostaResultado buscarPorApostaEquipePartida (Long idAposta, Long idEquipe, Long idPartida){
        TypedQuery<ApostaResultado> query = em.createNamedQuery("ApostaResultado.findByIdApostaAndIdEquipeAndIdPartida",entityClass);
        query.setParameter("idAposta", idAposta);
        query.setParameter("idEquipe", idEquipe);
        query.setParameter("idPartida", idPartida);
        return query.getSingleResult();
    }

    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }
    
}
