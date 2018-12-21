package com.cgi.dao;

import java.util.List;

	
public interface DAOGeneric<T, K> {
	    List<T> findAll();
	    T findByKey(K key);
	    void insert(T obj);
	    void update(T obj);
	    void delete(T obj);
	    void deleteByKey(K key);

}
