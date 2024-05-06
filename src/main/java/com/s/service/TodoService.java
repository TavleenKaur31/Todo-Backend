package com.s.service;

import java.util.List;

import com.s.entity.Todo;

public interface TodoService {
	
	public Todo add(Todo todo);
	public List<Todo> getAll();
	public Todo getById(int id);
	public Todo update(Todo todo , int id);
	public void delete(int id);
	
	

}
