package com.estudos.eventoapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.estudos.eventoapp.models.Evento;

public interface EventoRepository extends CrudRepository<Evento, String>{

}
