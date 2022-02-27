package com.cibertec.edu.matricula.servicios;

import java.util.List;

import com.cibertec.edu.matricula.entidades.Carrera;
import com.cibertec.edu.matricula.modelo.DaoManager;
import com.cibertec.edu.matricula.modelo.ICarreraDao;

public class CarreraService {

	DaoManager factory = DaoManager.getInstancia();
	ICarreraDao dao = factory.getCarreraDao();			
	
	public List<Carrera> listar() throws Exception {
		return dao.listar();
	}
	
	public boolean agregar(Carrera o) throws Exception{
		return dao.agregar(o);
	}
	
	public Carrera obtenerByID(Integer id) throws Exception {
		return dao.obtenerByID(id);
	}
	
	public boolean modificar(Carrera o) throws Exception {
		return dao.modificar(o);
	}
	
	public boolean eliminar(Integer id) throws Exception {
		return dao.eliminar(id);
	}
}
