package com.codewithsiva.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_app")
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String username;
    private  String password;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Todo> todoList;

}
