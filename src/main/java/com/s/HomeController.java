package com.s;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.s.entity.Todo;
import com.s.service.TodoServiceImpl;

@RestController
@RequestMapping("/todo")
@CrossOrigin("*")
public class HomeController {

	@Autowired
	private TodoServiceImpl service;

	@RequestMapping("/")
	public String start() {
		return "started....";

	}

	@PostMapping("/add")
	public Todo addTodo(@RequestBody Todo todo) {
		Todo t = this.service.add(todo);

		return t;

	}

	@GetMapping("/all")
	public List<Todo> getAllTodo() {

		List<Todo> all = this.service.getAll();

		return all;

	}
	
	@GetMapping("/all/{id}")
	public Todo getById(@PathVariable("id") int id) {
		Todo byId = this.service.getById(id);
		return byId;
		
	}
	
	@PutMapping("/update/{id}")
	public Todo updateTodo(@RequestBody Todo todo ,@PathVariable("id") int id) {
		
		Todo update = this.service.update(todo, id);
		return update;
		
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		
		this.service.delete(id);
		return "Todo Deleted successfully!!";
	}
}
