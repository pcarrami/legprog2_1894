package com.cibertec.edu.matricula.modelo;

import java.util.List;

import com.cibertec.edu.matricula.entidades.Tutor;

public interface ITutorDao extends GenericDao<Tutor, Integer>{
	public List<Tutor> buscar(String valor) throws Exception;
}
