/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bolaoservice.dao;

import com.bm.bolaoservice.entity.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Anderson
 */
public class UsuarioDAO extends AbstractPersistence<Usuario, Long> {

    private EntityManager em;

    public UsuarioDAO(EntityManager em) {
        super(Usuario.class);
        this.em=em;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<Usuario> consultarTodosUsuarios(){
        Query query = em.createNamedQuery("Usuario.findAll");
        return query.getResultList();
        
    }
    
    public Usuario consultarUsuarioEmail(String email){
        Query query = em.createNamedQuery("Usuario.findByEmail");
        query.setParameter("email", email);
        
        try{
            return (Usuario) query.getSingleResult();
        } catch (NoResultException ex){
            return null;
        }
    }
    
    public Usuario consultarUsuarioLogin(String email, String senha){
        Query query = em.createNamedQuery("Usuario.findLogin");
        query.setParameter("email", email);
        query.setParameter("senha", senha);
        try{
            return (Usuario) query.getSingleResult();
        } catch (NoResultException ex){
            return null;
        }
    }

}
