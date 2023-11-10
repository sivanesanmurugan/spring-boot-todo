package com.codewithsiva.service;

import com.codewithsiva.controller.TodoController;
import com.codewithsiva.model.Todo;
import com.codewithsiva.model.User;
import com.codewithsiva.repository.TodoRepository;
import com.codewithsiva.repository.UserRepository;
import com.codewithsiva.request.TodoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Todo> findAll(int userId) {
        return todoRepository.findAll()
                .stream()
                .filter(todo -> todo.getUser().getId() == userId)
                .collect(Collectors.toList());
    }

    public List<Todo> insertTodo(TodoRequest todo) {
        Todo originalTodo = new Todo();
        originalTodo.setTodo(todo.getTodo());
        User user = userRepository.findById(todo.getUserId()).get();
        originalTodo.setUser(user);
        todoRepository.save(originalTodo);
        return findAll(todo.getUserId());
    }

    public List<Todo> updateTodo(TodoRequest todo) {
        Todo originalTodo = new Todo();
        originalTodo.setId(todo.getId());
        originalTodo.setTodo(todo.getTodo());
        User user = userRepository.findById(todo.getUserId()).get();
        originalTodo.setUser(user);
        todoRepository.save(originalTodo);
        return findAll(todo.getUserId());
    }

    public List<Todo> deleteTodoById(Integer id) {
        int userId = todoRepository.findById(id).get().getUser().getId();
        todoRepository.deleteById(id);
        return findAll(userId);
    }
}
