package com.borntocode.main.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.borntocode.main.domain.Todo;

@Service
public class TodoService implements ITodoService {

	private RestClient restClient;

	public TodoService(RestClient restClient) {
		super();
		this.restClient = restClient;
	}

	@Override
	public Todo getTodo(int id) {
		return restClient.get().uri("todos/{id}", id).retrieve().body(Todo.class);
	}

	@Override
	public List<Todo> getAllTodos() {
		return restClient.get().uri("/todos").retrieve().body(new ParameterizedTypeReference<List<Todo>>() {
		});
	}

	@Override
	public Todo createPost(Todo todo) {
		return restClient.post().uri("/todos").contentType(MediaType.APPLICATION_JSON).body(todo).retrieve().body(Todo.class);
	}

}
