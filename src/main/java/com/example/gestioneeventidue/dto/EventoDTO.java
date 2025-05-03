package com.example.gestioneeventidue.dto;

import com.example.gestioneeventidue.models.Utente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EventoDTO {
    private Long id;
    private String titolo;
    private String descrizione;
    private LocalDate data;
    private String luogo;
    private long numeroDiPostiDisponibili;
    private UtenteDTO organizzatore;
    private List<UtenteDTO> partecipanti = new ArrayList<>();
}
