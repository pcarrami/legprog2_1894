package com.cibertec.edu.matricula.modelo;

public interface IDaoManager {
	IDepartamentoDao getDepartamentoDao();
	ICarreraDao getCarreraDao();
	IProvinciaDao getProvinciaDao();
	ITutorDao getTutorDao();
}
