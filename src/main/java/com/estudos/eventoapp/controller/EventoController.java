package com.estudos.eventoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.estudos.eventoapp.models.Evento;
import com.estudos.eventoapp.repository.EventoRepository;

@Controller
public class EventoController {

	@Autowired
	EventoRepository er;

	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.GET)
	public String form() {

		return "formEvento";
	}

	// *********************SALVA NO BANCO DE
	// DADOS****************************************************
	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.POST)
	public String salvar(Evento evento) {
		er.save(evento);
		return "redirect:/eventos";
	}

	// ********************CONSULTA O BANCO DE DADOS E RETORNA A LISTA ATUALIZADA NO
	// BROWSER**********
	@RequestMapping("/eventos")
	public ModelAndView listaEventos(Evento evento) {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Evento> eventos = er.findAll();
		mv.addObject("eventos", eventos);

		return mv;
	}
	
	
//DELETAR UM EVENTO DO BANCO DE DADOS
	@RequestMapping("/deletar")
	public String deletarEvento(Long id) {
		
		Evento evento = er.findById(id);
	
		er.delete(evento);

		return "redirect:/eventos";
	}

	

}
