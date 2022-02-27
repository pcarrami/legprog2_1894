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

import com.cibertec.edu.matricula.entidades.Departamento;
import com.cibertec.edu.matricula.entidades.Provincia;
import com.cibertec.edu.matricula.servicios.DepartamentoService;
import com.cibertec.edu.matricula.servicios.ProvinciaService;

/**
 * Servlet implementation class ProvinciaController
 */
@WebServlet(name="provinciaController", urlPatterns = {"/provincias"})
public class ProvinciaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	final String url_list ="./vistas/provincias/list.jsp";
	final String url_add="./vistas/provincias/add.jsp";
	final String url_edit = "./vistas/provincias/edit.jsp";
	ProvinciaService servicio = null;
	DepartamentoService servDepartamento = null;
	String valor = "";
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String acceso="";
		String accion = request.getParameter("accion");
		servicio = new ProvinciaService();
		try {
			if(accion.equalsIgnoreCase("listar")){
				List<Provincia> lista = servicio.listar();
				request.setAttribute("lista", lista);
				acceso = url_list;
			}else if(accion.equalsIgnoreCase("add")) {
				servDepartamento = new DepartamentoService();
				List<Departamento> lstDepartamentos = servDepartamento.listar(); 
				request.setAttribute("lstDepartamentos", lstDepartamentos);
				acceso=url_add;
			}else if(accion.equalsIgnoreCase("agregar")) {
				Integer id_prov, id_dep;
				String nombre;
				id_prov = Integer.parseInt(request.getParameter("txt_id_prov"));
				id_dep = Integer.parseInt(request.getParameter("cbo_id_depa"));
				nombre = request.getParameter("txt_nombre");
				Provincia obj = new Provincia(id_prov, nombre, id_dep);
				servicio.agregar(obj);
				List<Provincia> lista = servicio.listar();
				request.setAttribute("lista", lista);
				acceso = url_list;
			}else if(accion.equalsIgnoreCase("editar")) {
				Integer id_prov = Integer.parseInt(request.getParameter("id_prov"));
				Provincia obj = servicio.obtenerByID(id_prov);
				request.setAttribute("obj", obj);
				servDepartamento = new DepartamentoService();
				List<Departamento> lstDepartamentos = servDepartamento.listar(); 
				request.setAttribute("lstDepartamentos", lstDepartamentos);
				acceso = url_edit;
			}else if(accion.equalsIgnoreCase("actualizar")) {
				Integer id_prov, id_depa;
				String nombre;
				id_prov = Integer.parseInt(request.getParameter("txt_id_prov"));
				id_depa = Integer.parseInt(request.getParameter("cbo_id_depa"));
				nombre = request.getParameter("txt_nombre");
				Provincia obj = new Provincia(id_prov, nombre, id_depa);
				servicio.modificar(obj);
				List<Provincia> lista = servicio.listar();
				request.setAttribute("lista", lista);
				acceso = url_list;
			}else if(accion.equalsIgnoreCase("eliminar")) {
				Integer id_prov;
				id_prov = Integer.parseInt(request.getParameter("id_prov"));
				servicio.eliminar(id_prov);
				List<Provincia> lista = servicio.listar();
				request.setAttribute("lista", lista);
				acceso = url_list;
			}else if(accion.equalsIgnoreCase("buscar")) {
				valor = request.getParameter("valor");
				List<Provincia> lista = servicio.buscar(valor);
				request.setAttribute("lista", lista);
				request.setAttribute("valor", valor);
				acceso = url_list;
			}
		} catch (Exception e) {
			System.out.println("SIS-MAT-PROV-001" + e.getMessage());
		}
		request.setAttribute("valor", valor);
		RequestDispatcher vista = request.getRequestDispatcher(acceso);
		vista.forward(request, response);
		
	}

}
