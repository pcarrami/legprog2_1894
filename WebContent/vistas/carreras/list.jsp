<%@page import="java.util.Iterator"%>
<%@page import="com.cibertec.edu.matricula.entidades.Carrera"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="../../template/superior.jsp" %>

	
	<div class="container-fluid">
		<header>
		<label>CARRERAS</label>
		</header>
		<div class="navbar">
			<a class="btn btn-outline-success" href="./carreras?accion=add">+ Nuevo</a>
		</div>
		
		<table class="table table-bordered">
			<thead>
				<tr>
					<th class="text-center">ID</th>
					<th class="text-center">NOMBRE</th>
					<th class="text-center">ACCIONES</th>
				</tr>
			</thead>
			<tbody>
				<%
					ArrayList<Carrera> lista = (ArrayList<Carrera>) request.getAttribute("lista");
					Iterator<Carrera> itera = lista.iterator();
					Carrera obj = null;
					
					while(itera.hasNext()){
						obj = itera.next();
					
				
				%>
			
				<tr>
					<td class="text-center"><%=obj.getId_carrera() %></td>
					<td class="text-center"><%=obj.getNombre() %></td>
					<td class="text-center">
						<a class="btn btn-outline-warning" href="./carreras?accion=editar&id_carrera=<%=obj.getId_carrera() %>">Editar</a>
						<a class="btn btn-outline-danger" href="./carreras?accion=eliminar&id_carrera=<%=obj.getId_carrera() %>">Eliminar</a>
					</td>
				</tr>
				
				<%
					}
				%>
			
			</tbody>
		</table>
	</div>
<%@ include file="../../template/inferior.jsp" %>