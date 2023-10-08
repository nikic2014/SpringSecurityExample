package com.example.SpringSecurity.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class Person {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    int id;

    @NotEmpty(message = "Имя не может быть пустым")
    @Size(min = 2, max = 20, message = "Имя должно быть не короче 2 " +
            "символов, и не длинее 20")
    @Column(name="username")
    private String username;

    @Column(name="password")
    @Size(min = 4, max = 100, message = "Пароль должно быть не короче 2 " +
            "символов, и не длинее 100")
    private String password;

    public Person(){

    }

    public Person(int id, String username, String password) {
        this.id=id;
        this.username=username;
        this.password=password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
