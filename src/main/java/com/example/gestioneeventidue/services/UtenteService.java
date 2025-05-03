package com.example.gestioneeventidue.services;

import com.example.gestioneeventidue.dto.AsociaEventoRequest;
import com.example.gestioneeventidue.dto.CreateUtenteRequest;
import com.example.gestioneeventidue.dto.UtenteDTO;
import com.example.gestioneeventidue.mappers.UtenteMapper;
import com.example.gestioneeventidue.models.Evento;
import com.example.gestioneeventidue.models.Utente;
import com.example.gestioneeventidue.repositories.EventoRepository;
import com.example.gestioneeventidue.repositories.UtenteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UtenteService {
    private final UtenteRepository utenteRepository;
    private final UtenteMapper eventoMapper;
    private final EventoRepository eventoRepository;

    public void createUtente(CreateUtenteRequest eventoDTO) {
        Utente evento = new Utente();
        evento.setUsername(eventoDTO.getUsername());
        evento.setRuolo(eventoDTO.getRuolo());
        utenteRepository.save(evento);
    }

    public Utente getUtente(Long id) {
        return utenteRepository.findById(id).orElse(null);
    }

    public void deleteUtente(Long id) {
        utenteRepository.deleteById(id);
    }

    public void updateUtenteDTO(UtenteDTO eventoDTO) {
        Utente evento = eventoMapper.toEntity(eventoDTO);
        utenteRepository.findById(eventoDTO.getId()).orElseThrow(() -> new RuntimeException("Utente non trovato"));
        utenteRepository.save(evento);
    }

    @Transactional(rollbackOn = Exception.class)
    public void asociaEvento(AsociaEventoRequest asociaEventoRequest) {
        Utente utente = utenteRepository.findById(asociaEventoRequest.getIdUtente()).orElseThrow(() -> new RuntimeException("Utente non trovato"));
        Evento evento = eventoRepository.findById(asociaEventoRequest.getIdEvento()).orElseThrow(() -> new RuntimeException("Evento non trovato"));
        if (evento.getNumeroDiPostiDisponibili() > 0) {
            evento.setNumeroDiPostiDisponibili(evento.getNumeroDiPostiDisponibili() - 1);
            evento.getPartecipanti().add(utente);
            utente.getEventi().add(evento);
            utenteRepository.save(utente);
            eventoRepository.save(evento);
        }
    }
}
