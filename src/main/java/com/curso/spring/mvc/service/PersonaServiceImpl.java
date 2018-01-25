package com.curso.spring.mvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.curso.spring.mvc.dto.Persona;

@Service
public class PersonaServiceImpl implements PersonaService{

	@Override
	public Persona buscarPersonaPorId(String id) {

		Persona persona = new Persona();
		persona.setId("Bart");
		persona.setApellido("Simpson");
		return persona;
	}

	@Override
	public List<Persona> buscarPersonas(Persona persona) {
		List<Persona> resultados = new ArrayList<Persona>();
		Persona personaResultado = new Persona();
		persona.setId("Bart");
		persona.setApellido("Simpson");
		resultados.add(personaResultado);
		personaResultado = new Persona();
		persona.setId("Lisa");
		persona.setApellido("Simpson");
		return resultados;
	}

	@Override
	public void addPersona(Persona persona) {
		
		return;
	}

	@Override
	public void detelePersona(String id) {
		
		return;
	}

	@Override
	public Persona consultarPadre(String id) {
		Persona persona = new Persona();
		persona.setId("Homer");
		persona.setApellido("Simpson");
		return persona;
	}

	
}
