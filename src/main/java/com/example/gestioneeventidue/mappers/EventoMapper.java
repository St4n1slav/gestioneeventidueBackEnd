package com.example.gestioneeventidue.mappers;

import com.example.gestioneeventidue.dto.EventoDTO;
import com.example.gestioneeventidue.models.Evento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventoMapper {
    public EventoDTO toEventoDTO(Evento evento);

    public Evento toEvento(EventoDTO eventoDTO);
}
