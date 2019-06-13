package com.estudos.eventoapp.repository;

import javax.persistence.Id;

import org.springframework.data.repository.CrudRepository;

import com.estudos.eventoapp.models.Evento;

public interface IndexRepository extends CrudRepository<Evento, Id>{

}
