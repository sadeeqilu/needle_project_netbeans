package com.needle.database;

import java.util.List;

public interface DAO<T> {

	public T get(String t);
	public List<T> getAll();
	public boolean add(T t);
	public boolean update(T t);
	public boolean delete(T t);
}
