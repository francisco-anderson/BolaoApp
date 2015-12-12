/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bolaoservice.dao;

import com.bm.bolaoservice.entity.Resultado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Anderson
 */
public class ResultadoDAO extends AbstractPersistence<Resultado, Long>{
    
    private EntityManager em;
    
    public ResultadoDAO(EntityManager em){
        super(Resultado.class);
        this.em=em;
    }
    
  
    
    public List<Resultado> buscarPorEquipe(Long id){
        Query query = em.createNamedQuery("Resultado.findByIdEquipe");
        query.setParameter("idEquipe", id);
        return query.getResultList();
    }
    
    public List<Resultado> buscarPorPartida(Long id){
        Query query = em.createNamedQuery("Resultado.findByIdPartida");
        query.setParameter("idPartida", id);
        return query.getResultList();    }
    
    public Resultado buscarPorPartidaEquipe (Long idPartida,Long idEquipe){
        Query query = em.createNamedQuery("Resultado.finByIdPartidaAndIdEquipe");
        query.setParameter("idPartida", idPartida);
        query.setParameter("idEquipe", idEquipe);
        return (Resultado) query.getSingleResult();
    }
    


    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }
    
}
