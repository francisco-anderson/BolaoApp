/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bolaoservice.dao;

import com.bm.bolaoservice.entity.Campeonato;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Anderson
 */
public class CampeonatoDAO extends AbstractPersistence<Campeonato, Long> {

    private EntityManager em;

    public CampeonatoDAO(EntityManager em) {
        super(Campeonato.class);
        this.em = em;
    }

    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }

    public List<Campeonato> buscarCampeonatoNome(String nome) {
        Query query = em.createNamedQuery("Campeonato.findByNome");
        query.setParameter("nome", "%" + nome.toUpperCase() + "%");
        return query.getResultList();
    }

    public List<Campeonato> buscarCampeonatosPorDataStatus(Date datacomeco, Date datafim, String status) {
        Query query = em.createNamedQuery("Campeonato.findByDataInicioBetweenStatus");
        query.setParameter("datacomeco", datacomeco);
        query.setParameter("datafim", datafim);
        query.setParameter("status", status);
        return query.getResultList();
    }

    public List<Campeonato> buscarCampeonatoPorStatus(String status) {
        Query query = em.createNamedQuery("Campeonato.findByStatus");
        query.setParameter("status", status);
        return query.getResultList();
    }

    public List<Campeonato> buscarCampeonatoPorUsuario(Long id) {
        Query query = em.createNamedQuery("Campeonato.findByUsuario");
        query.setParameter("id", id);
        return query.getResultList();
    }

}
