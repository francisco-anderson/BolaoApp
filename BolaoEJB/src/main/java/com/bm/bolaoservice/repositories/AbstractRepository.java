package com.bm.bolaoservice.repositories;

import java.util.List;

import com.bm.bolaoservice.entity.AbstractEntity;

public interface AbstractRepository <T extends AbstractEntity, PK extends Number> {
	
	public T save (T entity);
	public void remove(PK id);
	public T find(PK id);
	public List<T> findAll();
	public List<T> findRange(int[] range);
	public Long count();
	

}
