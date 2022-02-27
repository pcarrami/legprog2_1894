package com.cibertec.edu.matricula.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.cibertec.edu.matricula.entidades.Tutor;


public class TutorDao implements ITutorDao{
	
	
	private Connection cn;
	private PreparedStatement ps;
	private CallableStatement cs;
	private ResultSet rs;
	private ArrayList<Tutor> lista;
	private Tutor obj;
	
	//sección de SQL PRE COMPILADO
	final String INSERT = "{call pa_insertar_tutores(?,?,?,?,?,?,?)}";
	final String UPDATE = "{call pa_modificar_tutor(?,?,?,?,?,?,?,?)}";
	final String DELETE = "{call pa_eliminar_tutor(?)}";
	final String GETALL = "{call pa_listar_tutores()}";
	final String GETBYID = "{call pa_get_tutor(?)}";
	final String SEARCH = "{call pa_buscar_tutores(?)}";
	
	public TutorDao(Connection cn) {
		this.cn= cn;
	}

	@Override
	public boolean agregar(Tutor o) throws Exception {
		int c = -1;
		try {
			cs = cn.prepareCall(INSERT);
			int i=1;
			cs.setString(i++, o.getDni());
			cs.setString(i++, o.getNombre());
			cs.setString(i++, o.getPapellido());
			cs.setString(i++, o.getSapellido());
			cs.setDate(i++, Date.valueOf(o.getFnacimiento()));
			cs.setString(i++, o.getTelefono());
			cs.setInt(i++, o.getId_prov());
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
	public boolean modificar(Tutor o) throws Exception {
		int c = -1;
		try {
			cs = cn.prepareCall(UPDATE);
			int i=1;
			cs.setString(i++, o.getDni());
			cs.setString(i++, o.getNombre());
			cs.setString(i++, o.getPapellido());
			cs.setString(i++, o.getSapellido());
			cs.setDate(i++, Date.valueOf(o.getFnacimiento()));
			cs.setString(i++, o.getTelefono());
			cs.setInt(i++, o.getId_prov());
			cs.setInt(i++, o.getId_tutor());
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
	public List<Tutor> listar() throws Exception {
		lista = new ArrayList<Tutor>();
		try {
			cs = cn.prepareCall(GETALL);
			rs = cs.executeQuery();
			
			while(rs.next()) {
				obj = new Tutor(
						rs.getInt("id_tutor"),
						rs.getString("dni"),
						rs.getString("nombre"),
						rs.getString("papellido"),
						rs.getString("sapellido"),
						rs.getDate("fnacimiento").toLocalDate(),
						rs.getString("telefono"),
						rs.getInt("id_prov")
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
	public Tutor obtenerByID(Integer id) throws Exception {
		try {
			cs = cn.prepareCall(GETBYID);
			cs.setInt(1, id);
			rs = cs.executeQuery();
			
			if(rs.next()) {
				obj = new Tutor(
						rs.getInt("id_tutor"),
						rs.getString("dni"),
						rs.getString("nombre"),
						rs.getString("papellido"),
						rs.getString("sapellido"),
						rs.getDate("fnacimiento").toLocalDate(),
						rs.getString("telefono"),
						rs.getInt("id_prov")
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
	public List<Tutor> buscar(String valor) throws Exception {
		lista = new ArrayList<Tutor>();
		try {
			cs = cn.prepareCall(SEARCH);
			int i =1;
			cs.setString(i++, valor);
			rs = cs.executeQuery();
			
			while(rs.next()) {
				obj = new Tutor(
						rs.getInt("id_tutor"),
						rs.getString("dni"),
						rs.getString("nombre"),
						rs.getString("papellido"),
						rs.getString("sapellido"),
						rs.getDate("fnacimiento").toLocalDate(),
						rs.getString("telefono"),
						rs.getInt("id_prov")
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
