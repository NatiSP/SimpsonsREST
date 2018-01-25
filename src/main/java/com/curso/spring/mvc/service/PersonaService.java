package com.curso.spring.mvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.curso.spring.mvc.dto.Persona;

@Service
public interface PersonaService {

	public Persona buscarPersonaPorId(String id);
	
	public List<Persona> buscarPersonas(Persona persona);
	
	public void addPersona(Persona persona);
	
	public void detelePersona(String id);
	
	public Persona consultarPadre(String id);

}
