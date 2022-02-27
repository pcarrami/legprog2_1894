package com.cibertec.edu.matricula.servicios;

import java.util.List;

import com.cibertec.edu.matricula.entidades.Tutor;
import com.cibertec.edu.matricula.modelo.DaoManager;
import com.cibertec.edu.matricula.modelo.ITutorDao;

public class TutorService {

	DaoManager factory = DaoManager.getInstancia();
	ITutorDao dao = factory.getTutorDao();			
	
	public List<Tutor> listar() throws Exception {
		return dao.listar();
	}
	
	public boolean agregar(Tutor o) throws Exception{
		return dao.agregar(o);
	}
	
	public Tutor obtenerByID(Integer id) throws Exception {
		return dao.obtenerByID(id);
	}
	
	public boolean modificar(Tutor o) throws Exception {
		return dao.modificar(o);
	}
	
	public boolean eliminar(Integer id) throws Exception {
		return dao.eliminar(id);
	}
	
	public List<Tutor> buscar(String valor) throws Exception {
		return dao.buscar(valor);
	}
}
