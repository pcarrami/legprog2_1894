package com.cibertec.edu.matricula.modelo;

import java.util.List;

import com.cibertec.edu.matricula.entidades.Departamento;

public interface IDepartamentoDao extends GenericDao<Departamento, Integer>{
	public List<Departamento> buscar(String valor) throws Exception;
}
