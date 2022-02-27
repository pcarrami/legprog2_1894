package com.cibertec.edu.matricula.modelo;

import java.util.List;

import com.cibertec.edu.matricula.entidades.Provincia;

public interface IProvinciaDao extends GenericDao<Provincia, Integer>{
	public List<Provincia> buscar(String valor) throws Exception;
}
