/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bolaoservice.dao;

import com.bm.bolaoservice.entity.Equipe;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Anderson
 */
public class EquipeDAO extends AbstractPersistence<Equipe, Long>{

    private EntityManager em;

    public EquipeDAO(EntityManager em) {        
        super(Equipe.class);
        this.em=em;
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }
    
    public List<Equipe> buscarPorNome(String nome){
        Query query = em.createNamedQuery("Equipe.findByNome");
        query.setParameter("nome", nome);
        return query.getResultList();
    }
    
    public List<Equipe> buscarPorUsuario(Long id){
        Query query = em.createNamedQuery("Equipe.findByUsuario");
        query.setParameter("idUsuario", id);
        return query.getResultList();
    }
    
     public List<Equipe> buscarEquipesPorCampeonato(Long id) {
        Query query = em.createNamedQuery("Equipe.findEquipeByCampeonato");
        query.setParameter("id", id);
        return query.getResultList();
    }
     
     public List<Equipe> buscarEquipePorPontuacaoGrupo(Long idUsuario,Long idCampeonato, String tipo){
         Query query = em.createNamedQuery("Equipe.findEquipeByPontuacaoPorGrupo");
         query.setParameter("idUsuario", idUsuario);
         query.setParameter("idCampeonato",idCampeonato);
         query.setParameter("tipo", tipo);
         return query.getResultList();
     }
    
}
