package com.borntocode.main.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.borntocode.main.domain.Todo;
import com.borntocode.main.service.ITodoService;

@RestController
@RequestMapping("/todos")
public class ToDoController {

	private ITodoService iTodoService;

	public ToDoController(ITodoService iTodoService) {
		super();
		this.iTodoService = iTodoService;
	}

//get single to do with id
	// http://localhost:8080/todos/1
	@GetMapping("/{id}")
	public Todo getSingleTodo(@PathVariable int id) {
		return iTodoService.getTodo(id);
	}

	@GetMapping("/")
	public List<Todo> getAllTodo() {
		return this.iTodoService.getAllTodos();
	}

	@PostMapping("/")
	public Todo createTodo(@RequestBody Todo todo) {
		return iTodoService.createPost(todo);
	}
}
