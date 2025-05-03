package com.example.gestioneeventidue.services;

import com.example.gestioneeventidue.dto.EventoDTO;
import com.example.gestioneeventidue.mappers.EventoMapper;
import com.example.gestioneeventidue.models.Evento;
import com.example.gestioneeventidue.repositories.EventoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventoService {
    private final EventoRepository eventoRepository;
    private final EventoMapper eventoMapper;

    public void createEvento(EventoDTO eventoDTO) {
        Evento evento = eventoMapper.toEvento(eventoDTO);
        eventoRepository.save(evento);
    }

    public Evento getEvento(Long id) {
        return eventoRepository.findById(id).orElse(null);
    }

    public void deleteEvento(Long id) {
        eventoRepository.deleteById(id);
    }

    public void updateEventoDTO(EventoDTO eventoDTO) {
        Evento evento = eventoMapper.toEvento(eventoDTO);
        eventoRepository.findById(eventoDTO.getId()).orElseThrow(() -> new RuntimeException("Evento non trovato"));
        eventoRepository.save(evento);
    }
}
