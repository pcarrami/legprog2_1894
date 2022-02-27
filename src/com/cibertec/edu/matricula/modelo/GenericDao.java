package com.cibertec.edu.matricula.modelo;

import java.util.List;

public interface GenericDao<T,K> {
	
	public boolean agregar(T o) throws Exception;
	public boolean modificar(T o) throws Exception;
	public boolean eliminar(K id) throws Exception;
	public List<T> listar() throws Exception;
	public T obtenerByID(K id) throws Exception;
	
}
