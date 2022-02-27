<%@page import="java.util.Iterator"%>
<%@page import="com.cibertec.edu.matricula.entidades.Tutor"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="../../template/superior.jsp" %>
	
	<div class="container-fluid">
		<header>
		<label>TUTORES</label>
		</header>
		<div class="navbar">
			<a class="btn btn-outline-success" href="./tutores?accion=add">+ Nuevo</a>
			<% String valor = String.valueOf(request.getAttribute("valor")); %>
			<form class="form-inline" method="post" action="./tutores">
				<input class="form-control" type="search" name="valor" value="<%=valor%>">
				<input class="btn btn-outline-success" type="submit" name="accion" value="Buscar">
			</form>
			
		</div>
		
		<table class="table table-bordered">
			<thead>
				<tr>
					<th class="text-center">ID</th>
					<th class="text-center">DNI</th>
					<th class="text-center">NOMBRE</th>
					<th class="text-center">APE. PATERNO</th>
					<th class="text-center">APE. MATERNO</th>
					<th class="text-center">FEC. NACIMIENTO</th>
					<th class="text-center">TELEFONO</th>
					<th class="text-center">ID PROV.</th>
					<th class="text-center">ACCIONES</th>
				</tr>
			</thead>
			<tbody>
				<%
					ArrayList<Tutor> lista = (ArrayList<Tutor>) request.getAttribute("lista");
					Iterator<Tutor> itera = lista.iterator();
					Tutor obj = null;
					
					while(itera.hasNext()){
						obj = itera.next();
					
				
				%>
			
				<tr>
					<td class="text-center"><%=obj.getId_tutor() %></td>
					<td class="text-center"><%=obj.getDni() %></td>
					<td class="text-center"><%=obj.getNombre() %></td>
					<td class="text-center"><%=obj.getPapellido() %></td>
					<td class="text-center"><%=obj.getSapellido() %></td>
					<td class="text-center"><%=obj.getFnacimiento() %></td>
					<td class="text-center"><%=obj.getTelefono() %></td>
					<td class="text-center"><%=obj.getId_prov() %></td>
					<td class="text-center">
						<a class="btn btn-outline-warning" href="./tutores?accion=editar&id_tutor=<%=obj.getId_tutor() %>">Editar</a>
						<a class="btn btn-outline-danger" href="./tutores?accion=eliminar&id_tutor=<%=obj.getId_tutor() %>">Eliminar</a>
					</td>
				</tr>
				
				<%
					}
				%>
			
			</tbody>
		</table>
	</div>
<%@ include file="../../template/inferior.jsp" %>