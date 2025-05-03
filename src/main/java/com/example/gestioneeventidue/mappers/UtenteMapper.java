package com.example.gestioneeventidue.mappers;

import com.example.gestioneeventidue.dto.UtenteDTO;
import com.example.gestioneeventidue.models.Utente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UtenteMapper {
    public UtenteDTO toDTO(Utente utente);

    public Utente toEntity(UtenteDTO utenteDTO);
}
