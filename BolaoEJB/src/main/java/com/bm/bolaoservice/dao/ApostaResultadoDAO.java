/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bolaoservice.dao;

import com.bm.bolaoservice.entity.ApostaResultado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Anderson
 */
public class ApostaResultadoDAO extends AbstractPersistence<ApostaResultado, Long>{
    
    private EntityManager em;
    
    public ApostaResultadoDAO(EntityManager em){
        super(ApostaResultado.class);
        this.em=em;
    }
      
    
  
    
    public List<ApostaResultado> buscarPorAposta(Long id){
        Query query = em.createNamedQuery("ApostaResultado.findByIdAposta");
        query.setParameter("idAposta", id);
        return query.getResultList();
    }
    
    public List<ApostaResultado> buscarPorEquipe(Long id){
        Query query = em.createNamedQuery("ApostaResultado.findByIdEquipe");
        query.setParameter("idEquipe", id);
        return query.getResultList();
    }
    
    public List<ApostaResultado> buscarPorPartida(Long id){
        Query query = em.createNamedQuery("ApostaResultado.findByIdPartida");
        query.setParameter("idPartida", id);
        return query.getResultList();
    }
    
    public List<ApostaResultado> buscarPorEquipePartida(Long idEquipe,Long idPartida){
        Query query = em.createNamedQuery("ApostaResultado.findByIdEquipeAndPartida");
        query.setParameter("idEquipe", idEquipe);
        query.setParameter("idPartida", idPartida);
        return query.getResultList();
    }
    
    public ApostaResultado buscarPorApostaEquipePartida (Long idAposta, Long idEquipe, Long idPartida){
        Query query = em.createNamedQuery("ApostaResultado.findByIdApostaAndIdEquipeAndIdPartida");
        query.setParameter("idAposta", idAposta);
        query.setParameter("idEquipe", idEquipe);
        query.setParameter("idPartida", idPartida);
        return (ApostaResultado) query.getSingleResult();
    }

    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }
    
}
