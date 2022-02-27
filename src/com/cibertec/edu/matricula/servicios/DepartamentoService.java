package com.cibertec.edu.matricula.servicios;

import java.util.List;

import com.cibertec.edu.matricula.entidades.Departamento;
import com.cibertec.edu.matricula.modelo.DaoManager;
import com.cibertec.edu.matricula.modelo.IDepartamentoDao;

public class DepartamentoService {

	DaoManager factory = DaoManager.getInstancia();
	IDepartamentoDao dao = factory.getDepartamentoDao();			
	
	public List<Departamento> listar() throws Exception {
		return dao.listar();
	}
	
	public boolean agregar(Departamento o) throws Exception{
		return dao.agregar(o);
	}
	
	public Departamento obtenerByID(Integer id) throws Exception {
		return dao.obtenerByID(id);
	}
	
	public boolean modificar(Departamento o) throws Exception {
		return dao.modificar(o);
	}
	
	public boolean eliminar(Integer id) throws Exception {
		return dao.eliminar(id);
	}
	
	public List<Departamento> buscar(String valor) throws Exception {
		return dao.buscar(valor);
	}
}
