/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bolaoservice.dao;

import com.bm.bolaoservice.entity.Aposta;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Anderson
 */
public class ApostaDAO extends AbstractPersistence<Aposta, Long>{

    private EntityManager em;
    
    public ApostaDAO(EntityManager em) {
        super(Aposta.class);
        this.em=em;
    }

    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }
    
    public List<Aposta> buscarPorUsuario(Long id){
        Query query = em.createNamedQuery("Aposta.findByUsuario");
        query.setParameter("id", id);
        return query.getResultList();
    }
    
}
