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
import javax.servlet.http.HttpSession;

import com.cibertec.edu.matricula.entidades.Departamento;
import com.cibertec.edu.matricula.servicios.DepartamentoService;

/**
 * Servlet implementation class DepartamentoController
 */
@WebServlet(name="departamentoController", urlPatterns = {"/departamentos"})
public class DepartamentoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	final String url_list ="./vistas/departamentos/list.jsp";
	final String url_add="./vistas/departamentos/add.jsp";
	final String url_edit = "./vistas/departamentos/edit.jsp";
	DepartamentoService servicio = null;
	String valor = "";
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String acceso="";
		String accion = request.getParameter("accion");
		servicio = new DepartamentoService();
		HttpSession session = request.getSession(true);
		try {
			if(accion.equalsIgnoreCase("listar")){
				List<Departamento> lista = servicio.listar();
				request.setAttribute("lista", lista);
				acceso = url_list;
			}else if(accion.equalsIgnoreCase("add")) {
				//request.getSession().setAttribute("usuario", request.getAttribute("usuario"));
				acceso=url_add;
			}else if(accion.equalsIgnoreCase("agregar")) {
				Integer id_depa;
				String nombre;
				
				id_depa = Integer.parseInt(request.getParameter("txt_id_depa"));
				nombre = request.getParameter("txt_nombre");
				Departamento obj = new Departamento(id_depa, nombre);
				servicio.agregar(obj);
				List<Departamento> lista = servicio.listar();
				request.setAttribute("lista", lista);
				acceso = url_list;
			}else if(accion.equalsIgnoreCase("editar")) {
				Integer id_depa = Integer.parseInt(request.getParameter("id_depa"));
				Departamento obj = servicio.obtenerByID(id_depa);
				request.setAttribute("obj", obj);
				acceso = url_edit;
			}else if(accion.equalsIgnoreCase("actualizar")) {
				Integer id_depa;
				String nombre;
				
				id_depa = Integer.parseInt(request.getParameter("txt_id_depa"));
				nombre = request.getParameter("txt_nombre");
				Departamento obj = new Departamento(id_depa, nombre);
				servicio.modificar(obj);
				List<Departamento> lista = servicio.listar();
				request.setAttribute("lista", lista);
				acceso = url_list;
			}else if(accion.equalsIgnoreCase("eliminar")) {
				Integer id_depa;
				id_depa = Integer.parseInt(request.getParameter("id_depa"));
				servicio.eliminar(id_depa);
				List<Departamento> lista = servicio.listar();
				request.setAttribute("lista", lista);
				acceso = url_list;
			}else if(accion.equalsIgnoreCase("buscar")) {
				valor = request.getParameter("valor");
				List<Departamento> lista = servicio.buscar(valor);
				request.setAttribute("lista", lista);
				request.setAttribute("valor", valor);
				acceso = url_list;
			}
		} catch (Exception e) {
			System.out.println("SIS-MAT-DEP-001" + e.getMessage());
		}
		request.setAttribute("valor", valor);
		RequestDispatcher vista = request.getRequestDispatcher(acceso);
		vista.forward(request, response);
		
	}

}
