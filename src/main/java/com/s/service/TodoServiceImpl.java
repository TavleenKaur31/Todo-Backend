package com.s.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.s.entity.Todo;
import com.s.repository.TodoRepo;

@Service
public class TodoServiceImpl implements TodoService {
	
	@Autowired
	private TodoRepo repo;

	@Override
	public Todo add(Todo todo) {
		 
		Todo t = this.repo.save(todo);
		
		return t;
	}

	@Override
	public List<Todo> getAll() {
		List<Todo> todoall = this.repo.findAll();
		return todoall;
	}

	@Override
	public Todo getById(int id) {
		  Todo byid = this.repo.findById(id).orElseThrow(() -> new RuntimeException());
		return byid;
	}

	@Override
	public Todo update(Todo todo, int id) {
		  
		todo.setId(id);
		Todo todo2 = this.repo.save(todo);
		 
		return todo2;
	}

	@Override
	public void delete(int id) {
		this.repo.deleteById(id);
		
	}

}
