package com.cibertec.edu.matricula.modelo;

import java.sql.Connection;

import com.cibertec.edu.matricula.cnx.Conexion;

public class DaoManager implements IDaoManager{
	
	
	//iniciando singleton
	private static final DaoManager instancia = new DaoManager();
	private Connection cn;
	
	private DaoManager() {
		cn = new Conexion().getConn();
	}
	
	public static DaoManager getInstancia() {
		return instancia;
	}
	
	//fin singleton
	
	//inicia mi Factory
	private IDepartamentoDao departamentoDao =  null;
	private ICarreraDao carreraDao = null;
	private IProvinciaDao provinciaDao =  null;
	private ITutorDao tutorDao =  null;

	@Override
	public IDepartamentoDao getDepartamentoDao() {
		if(departamentoDao==null) {
			departamentoDao = new DepartamentoDao(cn);
		}
		
		return departamentoDao;
	}

	@Override
	public ICarreraDao getCarreraDao() {
		if(carreraDao==null) {
			carreraDao = new CarreraDao(cn);
		}
		
		return carreraDao;
	}

	@Override
	public IProvinciaDao getProvinciaDao() {
		if(provinciaDao==null) {
			provinciaDao = new ProvinciaDao(cn);
		}
		
		return provinciaDao;
	}
	
	@Override
	public ITutorDao getTutorDao() {
		if(tutorDao==null) {
			tutorDao = new TutorDao(cn);
		}
		
		return tutorDao;
	}

}
