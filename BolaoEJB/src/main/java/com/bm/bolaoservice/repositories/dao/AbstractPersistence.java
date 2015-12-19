/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bm.bolaoservice.repositories.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.bm.bolaoservice.entity.AbstractEntity;
import com.bm.bolaoservice.repositories.AbstractRepository;

/**
 *
 * @author Anderson
 * @param <T>
 * @param <PK>
 */
public abstract class AbstractPersistence <T extends AbstractEntity, PK extends Number> implements AbstractRepository<T, PK> {
    
    private Class<T> entityClass;
	
	public AbstractPersistence(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	@Override
	public T save(T e) {
		if (e.getId() != null)
			return getEntityManager().merge(e);
		else {
			getEntityManager().persist(e);
			return e;
		}
	}
	@Override
	public void remove(PK id) {
            T entity=this.find(id);
		getEntityManager().remove(getEntityManager().merge(entity));
	}
	@Override
	public T find(PK id) {
		return getEntityManager().find(entityClass, id);
	}
	@Override
	public List<T> findAll() {
		CriteriaQuery<T> cq = getEntityManager().getCriteriaBuilder().createQuery(entityClass);
		cq.select(cq.from(entityClass));
		return getEntityManager().createQuery(cq).getResultList();
	}
	@Override
	public List<T> findRange(int[] range) {
		CriteriaQuery<T> cq = getEntityManager().getCriteriaBuilder().createQuery(entityClass);
		cq.select(cq.from(entityClass));
		TypedQuery<T> q = getEntityManager().createQuery(cq);
		q.setMaxResults(range[1] - range[0]);
		q.setFirstResult(range[0]);
		return q.getResultList();
	}
	@Override
	public Long count() {
		CriteriaQuery<Long> cq = getEntityManager().getCriteriaBuilder().createQuery(Long.class);
		Root<T> rt = cq.from(entityClass);
		cq.select(getEntityManager().getCriteriaBuilder().count(rt));
		TypedQuery<Long> q = getEntityManager().createQuery(cq);
		return  q.getSingleResult();
	}

	/**
	 * Exige a definição do <code>EntityManager</code> responsável pelas operações de persistência.
	 */
	protected abstract EntityManager getEntityManager();
    
}
