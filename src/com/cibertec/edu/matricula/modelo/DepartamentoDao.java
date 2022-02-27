package com.cibertec.edu.matricula.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cibertec.edu.matricula.entidades.Departamento;


public class DepartamentoDao implements IDepartamentoDao{
	
	
	private Connection cn;
	private PreparedStatement ps;
	private CallableStatement cs;
	private ResultSet rs;
	private ArrayList<Departamento> lista;
	private Departamento obj;
	
	//sección de SQL PRE COMPILADO
	final String INSERT = "{call pa_insertar_departamentos(?)}";
	final String UPDATE = "{call pa_modificar_departamento(?, ?)}";
	final String DELETE = "{call pa_eliminar_departamento(?)}";
	final String GETALL = "{call pa_listar_departamentos()}";
	final String GETBYID = "{call pa_get_departamento(?)}";
	final String SEARCH = "{call pa_buscar_departamentos(?)}";
	
	public DepartamentoDao(Connection cn) {
		this.cn= cn;
	}

	@Override
	public boolean agregar(Departamento o) throws Exception {
		int c = -1;
		try {
			cs = cn.prepareCall(INSERT);
			int i=1;
			cs.setString(i++, o.getNombre());
			c = cs.executeUpdate();
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
		
		return (c>0);
	}

	@Override
	public boolean modificar(Departamento o) throws Exception {
		int c = -1;
		try {
			cs = cn.prepareCall(UPDATE);
			int i=1;
			cs.setString(i++, o.getNombre());
			cs.setInt(i++, o.getId_depa());
			c = cs.executeUpdate();
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
		
		return (c>0);
	}

	@Override
	public boolean eliminar(Integer id) throws Exception {
		int c = -1;
		try {
			cs = cn.prepareCall(DELETE);
			int i=1;
			cs.setInt(i++, id);
			c = cs.executeUpdate();
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
		
		return (c>0);
	}

	@Override
	public List<Departamento> listar() throws Exception {
		lista = new ArrayList<Departamento>();
		try {
			cs = cn.prepareCall(GETALL);
			rs = cs.executeQuery();
			
			while(rs.next()) {
				obj = new Departamento(
						rs.getInt("id_depa"),
						rs.getString("nombre")
				);
				lista.add(obj);
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
		
		return lista;
	}

	@Override
	public Departamento obtenerByID(Integer id) throws Exception {
		try {
			cs = cn.prepareCall(GETBYID);
			cs.setInt(1, id);
			rs = cs.executeQuery();
			
			if(rs.next()) {
				obj = new Departamento(
						rs.getInt("id_depa"),
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

	@Override
	public List<Departamento> buscar(String valor) throws Exception {
		lista = new ArrayList<Departamento>();
		try {
			cs = cn.prepareCall(SEARCH);
			int i =1;
			cs.setString(i++, valor);
			rs = cs.executeQuery();
			
			while(rs.next()) {
				obj = new Departamento(
						rs.getInt("id_depa"),
						rs.getString("nombre")
				);
				lista.add(obj);
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
		
		return lista;
	}
	

}
