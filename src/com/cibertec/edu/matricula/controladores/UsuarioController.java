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

import com.cibertec.edu.matricula.entidades.Usuario;
import com.cibertec.edu.matricula.servicios.UsuarioService;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet(name="usuarioController", urlPatterns = {"/usuarios"})
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	final String url_list ="./vistas/usuarios/list.jsp";
	final String url_add="./vistas/usuarios/add.jsp";
	final String url_edit = "./vistas/usuarios/edit.jsp";
	final String url_index ="index.jsp";
	UsuarioService servicio = null;
	String valor = "";
	String user = "";
	String pass ="";
	Usuario obj = null;
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String acceso="";
		String accion = request.getParameter("accion");
		servicio = new UsuarioService();
		
		HttpSession session = request.getSession(true);
		
		try {
			if(accion.equalsIgnoreCase("listar")){
//				List<Usuario> lista = servicio.listar();
//				request.setAttribute("lista", lista);
//				acceso = url_list;
			}else if(accion.equalsIgnoreCase("add")) {
//				acceso=url_add;
			}else if(accion.equalsIgnoreCase("agregar")) {
//				Integer id_depa;
//				String nombre;
//				
//				id_depa = Integer.parseInt(request.getParameter("txt_id_depa"));
//				nombre = request.getParameter("txt_nombre");
//				Usuario obj = new Usuario(id_depa, nombre);
//				servicio.agregar(obj);
//				List<Usuario> lista = servicio.listar();
//				request.setAttribute("lista", lista);
//				acceso = url_list;
			}else if(accion.equalsIgnoreCase("editar")) {
//				Integer id_depa = Integer.parseInt(request.getParameter("id_depa"));
//				Usuario obj = servicio.obtenerByID(id_depa);
//				request.setAttribute("obj", obj);
//				acceso = url_edit;
			}else if(accion.equalsIgnoreCase("actualizar")) {
//				Integer id_depa;
//				String nombre;
//				
//				id_depa = Integer.parseInt(request.getParameter("txt_id_depa"));
//				nombre = request.getParameter("txt_nombre");
//				Usuario obj = new Usuario(id_depa, nombre);
//				servicio.modificar(obj);
//				List<Usuario> lista = servicio.listar();
//				request.setAttribute("lista", lista);
//				acceso = url_list;
			}else if(accion.equalsIgnoreCase("eliminar")) {
//				Integer id_depa;
//				id_depa = Integer.parseInt(request.getParameter("id_depa"));
//				servicio.eliminar(id_depa);
//				List<Usuario> lista = servicio.listar();
//				request.setAttribute("lista", lista);
//				acceso = url_list;
			}else if(accion.equalsIgnoreCase("buscar")) {
//				valor = request.getParameter("valor");
//				List<Usuario> lista = servicio.buscar(valor);
//				request.setAttribute("lista", lista);
//				request.setAttribute("valor", valor);
//				acceso = url_list;
			}else if(accion.equalsIgnoreCase("login")) {
				user = request.getParameter("user");
				pass = request.getParameter("pass");
				obj = new Usuario();
				obj.setUser(user);
				obj.setPass(pass);
				obj = servicio.validarUsuario(obj);
				if(obj!=null) {
					//request.setAttribute("usuario", obj);
					request.getSession().setAttribute("usuario", obj);
					acceso = url_index;
				}else {
					session.invalidate();
					request.setAttribute("mensaje", "Datos incorrectos");
					acceso = "login.jsp";
				}
			}
		} catch (Exception e) {
			System.out.println("SIS-MAT-DEP-001" + e.getMessage());
		}
		request.setAttribute("valor", valor);
		RequestDispatcher vista = request.getRequestDispatcher(acceso);
		vista.forward(request, response);
		
	}

}
