/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bolaoservice.repositories.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.bm.bolaoservice.entity.Equipe;

/**
 *
 * @author Anderson
 */
public class EquipeDAO extends AbstractPersistence<Equipe, Long>{

    private EntityManager em;
    private static final Class<Equipe> entityClass = Equipe.class;

    public EquipeDAO(EntityManager em) {        
        super(entityClass);
        this.em=em;
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }
    
    public List<Equipe> buscarPorNome(String nome){
        TypedQuery<Equipe> query = em.createNamedQuery("Equipe.findByNome",entityClass);
        query.setParameter("nome", nome);
        return query.getResultList();
    }
    
    public List<Equipe> buscarPorUsuario(Long id){
        TypedQuery<Equipe> query = em.createNamedQuery("Equipe.findByUsuario",entityClass);
        query.setParameter("idUsuario", id);
        return query.getResultList();
    }
    
     public List<Equipe> buscarEquipesPorCampeonato(Long id) {
        TypedQuery<Equipe> query = em.createNamedQuery("Equipe.findEquipeByCampeonato",entityClass);
        query.setParameter("id", id);
        return query.getResultList();
    }
     
     public List<Equipe> buscarEquipePorPontuacaoGrupo(Long idUsuario,Long idCampeonato, String tipo){
         TypedQuery<Equipe> query = em.createNamedQuery("Equipe.findEquipeByPontuacaoPorGrupo",entityClass);
         query.setParameter("idUsuario", idUsuario);
         query.setParameter("idCampeonato",idCampeonato);
         query.setParameter("tipo", tipo);
         return query.getResultList();
     }
    
}
