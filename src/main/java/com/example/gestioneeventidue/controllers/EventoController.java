package com.example.gestioneeventidue.controllers;

import com.example.gestioneeventidue.dto.EventoDTO;
import com.example.gestioneeventidue.models.Evento;
import com.example.gestioneeventidue.services.EventoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/evento")
public class EventoController {

    private final EventoService eventoService;

    @GetMapping("/{id}")
    public ResponseEntity<Evento> getEvento(@PathVariable Long id) {
        return ResponseEntity.ok(eventoService.getEvento(id));

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> createEvento(@RequestBody EventoDTO eventoDTO) {
        eventoService.createEvento(eventoDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEvento(@PathVariable Long id, @RequestBody EventoDTO eventoDTO) {
        eventoService.updateEventoDTO(eventoDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvento(@PathVariable Long id) {
        eventoService.deleteEvento(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
