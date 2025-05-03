package com.example.gestioneeventidue.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titolo;
    private String descrizione;
    private LocalDate data;
    private String luogo;
    private long numeroDiPostiDisponibili;
    @ManyToOne
    private Utente organizzatore;
    @ManyToMany(mappedBy = "eventi")
    private List<Utente> partecipanti = new ArrayList<>();
}
