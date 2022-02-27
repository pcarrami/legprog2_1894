<%@page import="java.util.Iterator"%>
<%@page import="com.cibertec.edu.matricula.entidades.Provincia"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="../../template/superior.jsp" %>


	
	<div class="container-fluid">
		<header>
		<label>PROVINCIAS</label>
		</header>
		<div class="navbar">
			<a class="btn btn-outline-success" href="./provincias?accion=add">+ Nuevo</a>
			<% String valor = String.valueOf(request.getAttribute("valor")); %>
			<form class="form-inline" method="post" action="./provincias">
				<input class="form-control" type="search" name="valor" value="<%=valor%>">
				<input class="btn btn-outline-success" type="submit" name="accion" value="Buscar">
			</form>
			
		</div>
		
		<table class="table table-bordered">
			<thead>
				<tr>
					<th class="text-center">ID</th>
					<th class="text-center">NOMBRE</th>
					<th class="text-center">ID DEPA</th>
					<th class="text-center">ACCIONES</th>
				</tr>
			</thead>
			<tbody>
				<%
					ArrayList<Provincia> lista = (ArrayList<Provincia>) request.getAttribute("lista");
					Iterator<Provincia> itera = lista.iterator();
					Provincia obj = null;
					
					while(itera.hasNext()){
						obj = itera.next();
					
				
				%>
			
				<tr>
					<td class="text-center"><%=obj.getId_prov() %></td>
					<td class="text-center"><%=obj.getNombre() %></td>
					<td class="text-center"><%=obj.getId_depa() %></td>
					<td class="text-center">
						<a class="btn btn-outline-warning" href="./provincias?accion=editar&id_prov=<%=obj.getId_prov() %>">Editar</a>
						<a class="btn btn-outline-danger" href="./provincias?accion=eliminar&id_prov=<%=obj.getId_prov() %>">Eliminar</a>
					</td>
				</tr>
				
				<%
					}
				%>
			
			</tbody>
		</table>
	</div>

<%@ include file="../../template/inferior.jsp" %>