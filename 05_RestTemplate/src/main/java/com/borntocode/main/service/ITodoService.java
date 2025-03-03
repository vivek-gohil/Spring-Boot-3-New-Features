package com.borntocode.main.service;

import java.util.List;

import com.borntocode.main.domain.Todo;

public interface ITodoService {
	Todo getTodo(int id);

	List<Todo> getAllTodos();

	Todo createPost(Todo todo);
}
