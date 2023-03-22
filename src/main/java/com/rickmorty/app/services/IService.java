package com.rickmorty.app.services;

import java.util.List;

public interface IService<T, S> {
	public T create(S obj);
	
	public List<T> getAll();
	
	public T getById(long id);
	
	public T update(S obj, long id);
	
	public void delete(long id);
}
