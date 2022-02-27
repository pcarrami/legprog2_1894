package com.cibertec.edu.matricula.entidades;

public class Carrera {
	private Integer id_carrera;
	private String nombre;
	
	public Carrera() {
	}

	public Carrera(Integer id_carrera, String nombre) {
		this.id_carrera = id_carrera;
		this.nombre = nombre;
	}

	public Integer getId_carrera() {
		return id_carrera;
	}

	public void setId_carrera(Integer id_carrera) {
		this.id_carrera = id_carrera;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
