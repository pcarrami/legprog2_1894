package com.cibertec.edu.matricula.controladores;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cibertec.edu.matricula.entidades.Provincia;
import com.cibertec.edu.matricula.entidades.Provincia;
import com.cibertec.edu.matricula.entidades.Tutor;
import com.cibertec.edu.matricula.servicios.ProvinciaService;
import com.cibertec.edu.matricula.servicios.ProvinciaService;
import com.cibertec.edu.matricula.servicios.TutorService;

/**
 * Servlet implementation class ProvinciaController
 */
@WebServlet(name="tutorController", urlPatterns = {"/tutores"})
public class TutorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	final String url_list ="./vistas/tutores/list.jsp";
	final String url_add="./vistas/tutores/add.jsp";
	final String url_edit = "./vistas/tutores/edit.jsp";
	TutorService servicio = null;
	ProvinciaService servProvincia = null;
	String valor = "";
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String acceso="";
		String accion = request.getParameter("accion");
		servicio = new TutorService();
		try {
			if(accion.equalsIgnoreCase("listar")){
				List<Tutor> lista = servicio.listar();
				request.setAttribute("lista", lista);
				acceso = url_list;
			}else if(accion.equalsIgnoreCase("add")) {
				servProvincia = new ProvinciaService();
				List<Provincia> lstProvincias = servProvincia.listar(); 
				request.setAttribute("lstProvincias", lstProvincias);
				acceso=url_add;
			}else if(accion.equalsIgnoreCase("agregar")) {
				Integer id_tutor, id_prov;
				String dni, nombre, papellido, sapellido, telefono, fecha;
				LocalDate fnacimiento;
				id_tutor= Integer.parseInt(request.getParameter("txt_id_tutor"));
				dni = request.getParameter("txt_dni");
				nombre = request.getParameter("txt_nombre");
				papellido = request.getParameter("txt_papellido");
				sapellido = request.getParameter("txt_sapellido");
				
				fecha = request.getParameter("dpt_fnacimiento");
				
				String[] a_fecha = fecha.split("-");
				int anio, mes, dia;
				anio = Integer.parseInt(a_fecha[0]);
				mes = Integer.parseInt(a_fecha[1]);
				dia = Integer.parseInt(a_fecha[2]);
				
				fnacimiento = LocalDate.of(anio, mes, dia);
				telefono = request.getParameter("txt_telefono");
				
				id_prov = Integer.parseInt(request.getParameter("cbo_id_prov"));
				
				Tutor obj = new Tutor(id_tutor, dni, nombre, papellido, sapellido, fnacimiento, telefono, id_prov);
				servicio.agregar(obj);
				List<Tutor> lista = servicio.listar();
				request.setAttribute("lista", lista);
				acceso = url_list;
			}else if(accion.equalsIgnoreCase("editar")) {
				Integer id_tutor = Integer.parseInt(request.getParameter("id_tutor"));
				Tutor obj = servicio.obtenerByID(id_tutor);
				request.setAttribute("obj", obj);
				servProvincia = new ProvinciaService();
				List<Provincia> lstProvincias = servProvincia.listar(); 
				request.setAttribute("lstProvincias", lstProvincias);
				acceso = url_edit;
			}else if(accion.equalsIgnoreCase("actualizar")) {
				Integer id_tutor, id_prov;
				String dni, nombre, papellido, sapellido, telefono, fecha;
				LocalDate fnacimiento;
				id_tutor= Integer.parseInt(request.getParameter("txt_id_tutor"));
				dni = request.getParameter("txt_dni");
				nombre = request.getParameter("txt_nombre");
				papellido = request.getParameter("txt_papellido");
				sapellido = request.getParameter("txt_sapellido");
				
				fecha = request.getParameter("dpt_fnacimiento");
				
				String[] a_fecha = fecha.split("-");
				int anio, mes, dia;
				anio = Integer.parseInt(a_fecha[0]);
				mes = Integer.parseInt(a_fecha[1]);
				dia = Integer.parseInt(a_fecha[2]);
				
				fnacimiento = LocalDate.of(anio, mes, dia);
				telefono = request.getParameter("txt_telefono");
				
				id_prov = Integer.parseInt(request.getParameter("cbo_id_prov"));
				
				Tutor obj = new Tutor(id_tutor, dni, nombre, papellido, sapellido, fnacimiento, telefono, id_prov);
				servicio.modificar(obj);
				List<Tutor> lista = servicio.listar();
				request.setAttribute("lista", lista);
				acceso = url_list;
			}else if(accion.equalsIgnoreCase("eliminar")) {
				Integer id_tutor;
				id_tutor = Integer.parseInt(request.getParameter("id_tutor"));
				servicio.eliminar(id_tutor);
				List<Tutor> lista = servicio.listar();
				request.setAttribute("lista", lista);
				acceso = url_list;
			}else if(accion.equalsIgnoreCase("buscar")) {
				valor = request.getParameter("valor");
				List<Tutor> lista = servicio.buscar(valor);
				request.setAttribute("lista", lista);
				request.setAttribute("valor", valor);
				acceso = url_list;
			}
		} catch (Exception e) {
			System.out.println("SIS-MAT-TUT-001" + e.getMessage());
		}
		request.setAttribute("valor", valor);
		RequestDispatcher vista = request.getRequestDispatcher(acceso);
		vista.forward(request, response);
		
	}

}
