package com.cibertec.edu.matricula.controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cibertec.edu.matricula.entidades.Carrera;
import com.cibertec.edu.matricula.servicios.CarreraService;

/**
 * Servlet implementation class CarreraController
 */
@WebServlet(name="carreraController", urlPatterns = {"/carreras"})
public class CarreraController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	final String url_list ="./vistas/carreras/list.jsp";
	final String url_add="./vistas/carreras/add.jsp";
	final String url_edit = "./vistas/carreras/edit.jsp";
	CarreraService servicio = null;
	List<Carrera> lista = null;
	Carrera obj =  null;
	String acceso="";
	Integer id_carrera;
	String nombre;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		String accion = request.getParameter("accion");
		servicio = new CarreraService();
		try {
			if(accion.equalsIgnoreCase("listar")){
				listar(request);
			}else if(accion.equalsIgnoreCase("add")) {
				acceso=url_add;
			}else if(accion.equalsIgnoreCase("agregar")) {
				setEntidad(request);
				servicio.agregar(obj);
				listar(request);
			}else if(accion.equalsIgnoreCase("editar")) {
				id_carrera = Integer.parseInt(request.getParameter("id_carrera"));
				obj = servicio.obtenerByID(id_carrera);
				request.setAttribute("obj", obj);
				acceso = url_edit;
			}else if(accion.equalsIgnoreCase("actualizar")) {
				setEntidad(request);
				servicio.modificar(obj);
				listar(request);
			}else if(accion.equalsIgnoreCase("eliminar")) {
				id_carrera = Integer.parseInt(request.getParameter("id_carrera"));
				servicio.eliminar(id_carrera);
				listar(request);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		RequestDispatcher vista = request.getRequestDispatcher(acceso);
		vista.forward(request, response);
		
	}
	
	private void listar(HttpServletRequest request) throws Exception{
		lista = servicio.listar();
		request.setAttribute("lista", lista);
		acceso = url_list;
	}
	
	private void setEntidad(HttpServletRequest request) throws Exception{
		id_carrera = Integer.parseInt(request.getParameter("txt_id_carrera"));
		nombre = request.getParameter("txt_nombre");
		obj = new Carrera(id_carrera, nombre);
	}

}
