package com.codewithsiva.controller;

import com.codewithsiva.model.Todo;
import com.codewithsiva.request.TodoRequest;
import com.codewithsiva.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/todo")
public class TodoController {

   @Autowired
   private TodoService todoService;

   @GetMapping("/all/{userId}")
   public List<Todo> getTodo(@PathVariable int userId) {
      return todoService.findAll(userId);
   }

   @PostMapping
   public List<Todo> addTodo(@RequestBody TodoRequest todo) {
      return todoService.insertTodo(todo);
   }

   @PutMapping
   public List<Todo> updateTodo(@RequestBody TodoRequest todo) {
      return todoService.updateTodo(todo);
   }

   @DeleteMapping("/delete/{id}")
   public List<Todo> deleteTodo(@PathVariable int id) {
      return todoService.deleteTodoById(id);
   }
}

