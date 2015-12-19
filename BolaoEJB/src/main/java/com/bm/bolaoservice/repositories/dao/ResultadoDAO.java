/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bolaoservice.repositories.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.bm.bolaoservice.entity.Resultado;

/**
 *
 * @author Anderson
 */
public class ResultadoDAO extends AbstractPersistence<Resultado, Long>{
    
    private EntityManager em;
    private static final Class<Resultado> entityClass = Resultado.class;
    
    public ResultadoDAO(EntityManager em){
        super(entityClass);
        this.em=em;
    }
    
  
    
    public List<Resultado> buscarPorEquipe(Long id){
        TypedQuery<Resultado> query = em.createNamedQuery("Resultado.findByIdEquipe",entityClass);
        query.setParameter("idEquipe", id);
        return query.getResultList();
    }
    
    public List<Resultado> buscarPorPartida(Long id){
        TypedQuery<Resultado> query = em.createNamedQuery("Resultado.findByIdPartida",entityClass);
        query.setParameter("idPartida", id);
        return query.getResultList();    }
    
    public Resultado buscarPorPartidaEquipe (Long idPartida,Long idEquipe){
        TypedQuery<Resultado> query = em.createNamedQuery("Resultado.finByIdPartidaAndIdEquipe",entityClass);
        query.setParameter("idPartida", idPartida);
        query.setParameter("idEquipe", idEquipe);
        return (Resultado) query.getSingleResult();
    }
    


    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }
    
}
