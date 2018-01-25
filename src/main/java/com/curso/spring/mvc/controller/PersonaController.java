package com.curso.spring.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.curso.spring.mvc.dto.Persona;
import com.curso.spring.mvc.service.PersonaService;

@Controller
@RequestMapping("/characters")
public class PersonaController {

	@Autowired
	private PersonaService personaService;
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody public Persona consultaPorId(String id) {
		return personaService.buscarPersonaPorId(id);	
	}
	
	@RequestMapping(path = "/{id}/father", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Persona consultarPadre(String id) {
		return personaService.consultarPadre(id);	
	}
	
	@RequestMapping(method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Persona> consultar(@RequestParam Persona persona) {
		return personaService.buscarPersonas(persona);	
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void addPersona(@RequestParam Persona persona) {
		personaService.addPersona(persona);	
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void borrarPorId(String id) {
		personaService.detelePersona(id);	
	}
}
