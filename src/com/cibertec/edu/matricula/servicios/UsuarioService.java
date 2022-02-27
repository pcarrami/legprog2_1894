package com.cibertec.edu.matricula.servicios;

import java.util.List;

import com.cibertec.edu.matricula.entidades.Usuario;
import com.cibertec.edu.matricula.modelo.DaoManager;
import com.cibertec.edu.matricula.modelo.IUsuarioDao;

public class UsuarioService {

	DaoManager factory = DaoManager.getInstancia();
	IUsuarioDao dao = factory.getUsuarioDao();			
	
	public List<Usuario> listar() throws Exception {
		return dao.listar();
	}
	
	public boolean agregar(Usuario o) throws Exception{
		return dao.agregar(o);
	}
	
	public Usuario obtenerByID(Integer id) throws Exception {
		return dao.obtenerByID(id);
	}
	
	public boolean modificar(Usuario o) throws Exception {
		return dao.modificar(o);
	}
	
	public boolean eliminar(Integer id) throws Exception {
		return dao.eliminar(id);
	}
	
	public List<Usuario> buscar(String valor) throws Exception {
		return dao.buscar(valor);
	}
	
	public Usuario validarUsuario(Usuario o) throws Exception {
		return dao.validarUsuario(o);
	}
	
}
