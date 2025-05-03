package com.example.gestioneeventidue.dto;

import com.example.gestioneeventidue.models.Evento;
import com.example.gestioneeventidue.models.Ruolo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UtenteDTO {
    private Long id;
    private String username;
    private Ruolo ruolo;
    private List<EventoDTO> eventi = new ArrayList<>();

}
