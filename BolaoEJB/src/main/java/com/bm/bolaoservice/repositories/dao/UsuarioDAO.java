/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bolaoservice.repositories.dao;

import java.util.List;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.bm.bolaoservice.entity.Usuario;
import com.bm.bolaoservice.repositories.UsuarioRepository;

/**
 *
 * @author Anderson
 */

@Singleton
public class UsuarioDAO extends AbstractPersistence<Usuario, Long> implements UsuarioRepository {
	
	@PersistenceContext(unitName = "persistencia")
    private EntityManager em;
    private static final Class<Usuario> entityClass = Usuario.class;

    public UsuarioDAO() {
        super(entityClass);
      
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<Usuario> consultarTodosUsuarios(){
        TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findAll",entityClass);
        return query.getResultList();
        
    }
    
    public Usuario consultarUsuarioEmail(String email){
        TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findByEmail",entityClass);
        query.setParameter("email", email);
        
        try{
            return  query.getSingleResult();
        } catch (NoResultException ex){
            return null;
        }
    }
    
    public Usuario consultarUsuarioLogin(String email, String senha){
        TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findLogin",entityClass);
        query.setParameter("email", email);
        query.setParameter("senha", senha);
        try{
            return  query.getSingleResult();
        } catch (NoResultException ex){
            return null;
        }
    }

	@Override
	public List<Usuario> consultarUsuarioPorEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean realizarLogin(String email, String senha) {
		// TODO Auto-generated method stub
		return false;
	}

}
