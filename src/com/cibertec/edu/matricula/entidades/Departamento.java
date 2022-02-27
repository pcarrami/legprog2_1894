package com.cibertec.edu.matricula.entidades;

public class Departamento {
	private Integer id_depa;
	private String nombre;
	
	public Departamento() {
	}

	public Departamento(Integer id_depa, String nombre) {
		this.id_depa = id_depa;
		this.nombre = nombre;
	}

	public Integer getId_depa() {
		return id_depa;
	}

	public void setId_depa(Integer id_depa) {
		this.id_depa = id_depa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
