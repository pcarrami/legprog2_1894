package com.cibertec.edu.matricula.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cibertec.edu.matricula.entidades.Usuario;


public class UsuarioDao implements IUsuarioDao{
	
	
	private Connection cn;
	private PreparedStatement ps;
	private CallableStatement cs;
	private ResultSet rs;
	private ArrayList<Usuario> lista;
	private Usuario obj =  null;
	
	//sección de SQL PRE COMPILADO
	final String INSERT = "{call pa_insertar_departamentos(?)}";
	final String UPDATE = "{call pa_modificar_departamento(?, ?)}";
	final String DELETE = "{call pa_eliminar_departamento(?)}";
	final String GETALL = "{call pa_listar_departamentos()}";
	final String GETBYID = "{call pa_get_departamento(?)}";
	final String SEARCH = "{call pa_buscar_departamentos(?)}";
	final String VALIDAR = "{call pa_validar_usuario(?, ?)}";
	
	public UsuarioDao(Connection cn) {
		this.cn= cn;
	}

	@Override
	public boolean agregar(Usuario o) throws Exception {
//		int c = -1;
//		try {
//			cs = cn.prepareCall(INSERT);
//			int i=1;
//			cs.setString(i++, o.getNombre());
//			c = cs.executeUpdate();
//		} catch (SQLException e) {
//			System.out.println("Error: "+ e.getMessage());
//		}finally {
//			try {
//				if(ps!=null) ps.close();
//				//if(cn!=null) cn.close();
//			} catch (SQLException e) {
//				System.out.println("Error: "+ e.getMessage());
//			}
//		}
//		
//		return (c>0);
		return false;
	}

	@Override
	public boolean modificar(Usuario o) throws Exception {
//		int c = -1;
//		try {
//			cs = cn.prepareCall(UPDATE);
//			int i=1;
//			cs.setString(i++, o.getNombre());
//			cs.setInt(i++, o.getId_depa());
//			c = cs.executeUpdate();
//		} catch (SQLException e) {
//			System.out.println("Error: "+ e.getMessage());
//		}finally {
//			try {
//				if(ps!=null) ps.close();
//				//if(cn!=null) cn.close();
//			} catch (SQLException e) {
//				System.out.println("Error: "+ e.getMessage());
//			}
//		}
//		
//		return (c>0);
		return false;
	}

	@Override
	public boolean eliminar(Integer id) throws Exception {
//		int c = -1;
//		try {
//			cs = cn.prepareCall(DELETE);
//			int i=1;
//			cs.setInt(i++, id);
//			c = cs.executeUpdate();
//		} catch (SQLException e) {
//			System.out.println("Error: "+ e.getMessage());
//		}finally {
//			try {
//				if(ps!=null) ps.close();
//				//if(cn!=null) cn.close();
//			} catch (SQLException e) {
//				System.out.println("Error: "+ e.getMessage());
//			}
//		}
//		
//		return (c>0);
		return false;
	}

	@Override
	public List<Usuario> listar() throws Exception {
//		lista = new ArrayList<Usuario>();
//		try {
//			cs = cn.prepareCall(GETALL);
//			rs = cs.executeQuery();
//			
//			while(rs.next()) {
//				obj = new Usuario(
//						rs.getInt("id_depa"),
//						rs.getString("nombre")
//				);
//				lista.add(obj);
//			}
//			
//		} catch (SQLException e) {
//			System.out.println("Error: "+ e.getMessage());
//		}finally {
//			try {
//				if(ps!=null) ps.close();
//				//if(cn!=null) cn.close();
//			} catch (SQLException e) {
//				System.out.println("Error: "+ e.getMessage());
//			}
//		}
//		
//		return lista;
		return null;
	}

	@Override
	public Usuario obtenerByID(Integer id) throws Exception {
//		try {
//			cs = cn.prepareCall(GETBYID);
//			cs.setInt(1, id);
//			rs = cs.executeQuery();
//			
//			if(rs.next()) {
//				obj = new Usuario(
//						rs.getInt("id_depa"),
//						rs.getString("nombre")
//				);
//			}
//			
//		} catch (SQLException e) {
//			System.out.println("Error: "+ e.getMessage());
//		}finally {
//			try {
//				if(ps!=null) ps.close();
//				//if(cn!=null) cn.close();
//			} catch (SQLException e) {
//				System.out.println("Error: "+ e.getMessage());
//			}
//		}
//		
//		return obj;
		return null;
	}

	@Override
	public List<Usuario> buscar(String valor) throws Exception {
//		lista = new ArrayList<Usuario>();
//		try {
//			cs = cn.prepareCall(SEARCH);
//			int i =1;
//			cs.setString(i++, valor);
//			rs = cs.executeQuery();
//			
//			while(rs.next()) {
//				obj = new Usuario(
//						rs.getInt("id_depa"),
//						rs.getString("nombre")
//				);
//				lista.add(obj);
//			}
//			
//		} catch (SQLException e) {
//			System.out.println("Error: "+ e.getMessage());
//		}finally {
//			try {
//				if(ps!=null) ps.close();
//				//if(cn!=null) cn.close();
//			} catch (SQLException e) {
//				System.out.println("Error: "+ e.getMessage());
//			}
//		}
//		
//		return lista;
		return null;
	}

	@Override
	public Usuario validarUsuario(Usuario o) throws Exception {
		try {
		cs = cn.prepareCall(VALIDAR);
		int i=1;
		cs.setString(i++, o.getUser());
		cs.setString(i++, o.getPass());
		rs = cs.executeQuery();
		obj = null;
		if(rs.next()) {
			obj = new Usuario(
					rs.getInt("id_usuario"),
					rs.getString("user"),
					rs.getString("pass"),
					rs.getString("nombre")
			);
		}
		
		} catch (SQLException e) {
			System.out.println("Error: "+ e.getMessage());
		}finally {
			try {
				if(ps!=null) ps.close();
				//if(cn!=null) cn.close();
			} catch (SQLException e) {
				System.out.println("Error: "+ e.getMessage());
			}
		}
		
		return obj;
	}
	

}
