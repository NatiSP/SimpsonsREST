package com.curso.spring.mvc.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.curso.spring.mvc.dto.Persona;
import com.curso.spring.mvc.service.PersonaService;

@RestController
@RequestMapping("/characters")
public class PersonaController {

	@Autowired
	private PersonaService personaService;
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Persona consultaPorId(@PathVariable String id) {
		return personaService.buscarPersonaPorId(id);	
	}
	
	@RequestMapping(path = "/{id}/father", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Persona consultarPadre(@PathVariable String id) {
		return personaService.consultarPadre(id);	
	}
	
	@RequestMapping(method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Persona> consultarTodos() {
		Persona persona = new Persona();
		return personaService.buscarPersonas(persona);	
	}
	
	@RequestMapping(method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE, params="apellido")
	public List<Persona> consultarPorApellido(@PathVariable String apellido) {
		Persona persona = new Persona();
		persona.setApellido(apellido);
		return personaService.buscarPersonas(persona);	
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Void> addPersona(@RequestBody Persona persona) throws URISyntaxException {
		personaService.addPersona(persona);	
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(new URI("http://localhost:8080/Simpsons/characters/" + persona.getId()));
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void borrarPorId(@PathVariable String id) {
		personaService.detelePersona(id);	
	}
}
