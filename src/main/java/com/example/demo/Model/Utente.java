package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Utente {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String name;
    private String mail;
    private String password;

    public Utente(String username, String name, String mail, String password) {
        this.username = username;
        this.name = name;
        this.mail = mail;
        this.password = password;
    }
}
