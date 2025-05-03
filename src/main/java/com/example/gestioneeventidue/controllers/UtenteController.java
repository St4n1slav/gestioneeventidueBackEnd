package com.example.gestioneeventidue.controllers;

import com.example.gestioneeventidue.dto.AsociaEventoRequest;
import com.example.gestioneeventidue.dto.CreateUtenteRequest;
import com.example.gestioneeventidue.dto.UtenteDTO;
import com.example.gestioneeventidue.models.Utente;
import com.example.gestioneeventidue.services.UtenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/utente")
public class UtenteController {

    private final UtenteService eventoService;

    @GetMapping("/{id}")
    public ResponseEntity<Utente> getUtente(@PathVariable Long id) {
        return ResponseEntity.ok(eventoService.getUtente(id));

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> createUtente(@RequestBody CreateUtenteRequest eventoDTO) {
        eventoService.createUtente(eventoDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUtente(@PathVariable Long id, @RequestBody UtenteDTO eventoDTO) {
        eventoService.updateUtenteDTO(eventoDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUtente(@PathVariable Long id) {
        eventoService.deleteUtente(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/asociaEvento")
    public ResponseEntity<Void> asociaEvento(@RequestBody AsociaEventoRequest asociaEventoRequest) {
        eventoService.asociaEvento(asociaEventoRequest);
        return ResponseEntity.ok().build();
    }
}
