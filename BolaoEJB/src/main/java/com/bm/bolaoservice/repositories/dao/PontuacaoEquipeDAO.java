/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bolaoservice.repositories.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.bm.bolaoservice.entity.PontuacaoEquipe;

/**
 *
 * @author Anderson
 */
public class PontuacaoEquipeDAO extends AbstractPersistence<PontuacaoEquipe, Long>{
    
    private EntityManager em;
    private static final Class<PontuacaoEquipe> entityClass = PontuacaoEquipe.class;

    public PontuacaoEquipeDAO(EntityManager em) {
        super(entityClass);
        this.em=em;
    }

    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }
    
    public List<PontuacaoEquipe> buscarPorEquipe(Long id){
        TypedQuery<PontuacaoEquipe> query = em.createNamedQuery("PontuacaoEquipe.findByEquipe",entityClass);
        query.setParameter("idEquipe", id);
        return query.getResultList();
    }
    
    public List<PontuacaoEquipe> buscarPorCampeonato(Long id){
        TypedQuery<PontuacaoEquipe> query = em.createNamedQuery("PontuacaoEquipe.findByCampeonato",entityClass);
        query.setParameter("idCampeonato", id);
        return  query.getResultList();
    }
    
    public PontuacaoEquipe buscarPorCampeonatoEquipe(Long idCampeonato,Long idEquipe){
        TypedQuery<PontuacaoEquipe> query = em.createNamedQuery("PontuacaoEquipe.findByEquipeAndCampeonato",entityClass);
        query.setParameter("idCampeonato", idCampeonato);
        query.setParameter("idEquipe", idEquipe);
        try{
        return (PontuacaoEquipe) query.getSingleResult();
        } catch (NoResultException ex){
            return null;
        }
    } 
    
}
