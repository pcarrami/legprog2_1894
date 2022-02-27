package com.cibertec.edu.matricula.modelo;

import java.util.List;

import com.cibertec.edu.matricula.entidades.Usuario;

public interface IUsuarioDao extends GenericDao<Usuario, Integer>{
	public List<Usuario> buscar(String valor) throws Exception;
	public Usuario validarUsuario(Usuario o) throws Exception;
}
