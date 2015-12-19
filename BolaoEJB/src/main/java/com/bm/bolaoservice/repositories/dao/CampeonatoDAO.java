/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bolaoservice.repositories.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.bm.bolaoservice.entity.Campeonato;

/**
 *
 * @author Anderson
 */
public class CampeonatoDAO extends AbstractPersistence<Campeonato, Long> {

    private EntityManager em;
    private static final Class<Campeonato> entityClass = Campeonato.class;

    public CampeonatoDAO(EntityManager em) {
        super(entityClass);
        this.em = em;
    }

    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }

    public List<Campeonato> buscarCampeonatoNome(String nome) {
        TypedQuery<Campeonato> query = em.createNamedQuery("Campeonato.findByNome",entityClass);
        query.setParameter("nome", "%" + nome.toUpperCase() + "%");
        return query.getResultList();
    }

    public List<Campeonato> buscarCampeonatosPorDataStatus(Date datacomeco, Date datafim, String status) {
        TypedQuery<Campeonato> query = em.createNamedQuery("Campeonato.findByDataInicioBetweenStatus",entityClass);
        query.setParameter("datacomeco", datacomeco);
        query.setParameter("datafim", datafim);
        query.setParameter("status", status);
        return query.getResultList();
    }

    public List<Campeonato> buscarCampeonatoPorStatus(String status) {
        TypedQuery<Campeonato> query = em.createNamedQuery("Campeonato.findByStatus",entityClass);
        query.setParameter("status", status);
        return query.getResultList();
    }

    public List<Campeonato> buscarCampeonatoPorUsuario(Long id) {
        TypedQuery<Campeonato> query = em.createNamedQuery("Campeonato.findByUsuario",entityClass);
        query.setParameter("id", id);
        return query.getResultList();
    }

}
