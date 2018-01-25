package com.curso.spring.mvc.dto;

public class Persona {

	private String id;
	private String nombre;
	private String padre;
	private String apellido;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPadre() {
		return padre;
	}
	public void setPadre(String padre) {
		this.padre = padre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
}
