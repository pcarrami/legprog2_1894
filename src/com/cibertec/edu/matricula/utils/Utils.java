package com.cibertec.edu.matricula.utils;

import java.time.LocalDate;

public class Utils {
	public static LocalDate StringToLocalDate(String fecha) {
		String[] a_fecha = fecha.split("-");
		int anio, mes, dia;
		anio = Integer.parseInt(a_fecha[0]);
		mes = Integer.parseInt(a_fecha[1]);
		dia = Integer.parseInt(a_fecha[2]);
		
		return LocalDate.of(anio, mes, dia);
	}
}
