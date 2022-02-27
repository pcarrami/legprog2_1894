<%@page import="java.util.Iterator"%>
<%@page import="com.cibertec.edu.matricula.entidades.Departamento"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="../../template/superior.jsp" %>

	
	<div class="container-fluid">
		<header>
			<label>DEPARTAMENTOS</label>
		</header>
		<div class="navbar">
			<a class="btn btn-outline-success" href="./departamentos?accion=add">+ Nuevo</a>
			<% String valor = String.valueOf(request.getAttribute("valor")); %>
			<form class="form-inline" method="post" action="./departamentos">
				<input class="form-control" type="search" name="valor" value="<%=valor%>">
				<input class="btn btn-outline-success" type="submit" name="accion" value="Buscar">
			</form>
			
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
					ArrayList<Departamento> lista = (ArrayList<Departamento>) request.getAttribute("lista");
					Iterator<Departamento> itera = lista.iterator();
					Departamento obj = null;
					
					while(itera.hasNext()){
						obj = itera.next();
					
				
				%>
			
				<tr>
					<td class="text-center"><%=obj.getId_depa() %></td>
					<td class="text-center"><%=obj.getNombre() %></td>
					<td class="text-center">
						<a class="btn btn-outline-warning" href="./departamentos?accion=editar&id_depa=<%=obj.getId_depa() %>">Editar</a>
						<a class="btn btn-outline-danger" href="./departamentos?accion=eliminar&id_depa=<%=obj.getId_depa() %>">Eliminar</a>
					</td>
				</tr>
				
				<%
					}
				%>
			
			</tbody>
		</table>
	</div>

<%@ include file="../../template/inferior.jsp" %>