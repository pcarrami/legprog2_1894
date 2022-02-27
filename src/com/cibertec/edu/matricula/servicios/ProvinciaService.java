package com.cibertec.edu.matricula.servicios;

import java.util.List;

import com.cibertec.edu.matricula.entidades.Provincia;
import com.cibertec.edu.matricula.modelo.DaoManager;
import com.cibertec.edu.matricula.modelo.IProvinciaDao;

public class ProvinciaService {

	DaoManager factory = DaoManager.getInstancia();
	IProvinciaDao dao = factory.getProvinciaDao();			
	
	public List<Provincia> listar() throws Exception {
		return dao.listar();
	}
	
	public boolean agregar(Provincia o) throws Exception{
		return dao.agregar(o);
	}
	
	public Provincia obtenerByID(Integer id) throws Exception {
		return dao.obtenerByID(id);
	}
	
	public boolean modificar(Provincia o) throws Exception {
		return dao.modificar(o);
	}
	
	public boolean eliminar(Integer id) throws Exception {
		return dao.eliminar(id);
	}
	
	public List<Provincia> buscar(String valor) throws Exception {
		return dao.buscar(valor);
	}
}
