package com.cibertec.edu.matricula.entidades;

public class Usuario {
	private Integer id_usuario;
	private String user;
	private String pass;
	private String nombre;
	
	public Usuario() {
	}

	public Usuario(Integer id_usuario, String user, String pass, String nombre) {
		this.id_usuario = id_usuario;
		this.user = user;
		this.pass = pass;
		this.nombre = nombre;
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
