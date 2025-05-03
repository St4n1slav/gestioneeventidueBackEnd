package com.example.gestioneeventidue.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    @Enumerated(EnumType.STRING)
    private Ruolo ruolo;
    @ManyToMany
    private List<Evento> eventi = new ArrayList<>();

}
