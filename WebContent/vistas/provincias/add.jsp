<%@page import="com.cibertec.edu.matricula.entidades.Departamento"%>
<%@page import="java.util.List"%>
<%@ include file="../../template/superior.jsp" %>

	<div class="container-fluid">
		<header>
			<label>PROVINCIAS</label>
		</header>
		<div class="col-lg-8">
			<h1>AGREGAR PROVINCIA</h1>
			<% List<Departamento> lstDepartamentos = (List<Departamento>) request.getAttribute("lstDepartamentos"); %>
			<form action="./provincias" method="post">
				ID: <br>
				<input class="form-control" type="text" name="txt_id_prov"> <br>
				NOMBRE: <br>
				<input class="form-control" type="text" name="txt_nombre"> <br>
				DEPARTAMENTOS: <br>
				<select class="form-control" name="cbo_id_depa">
				<% if(lstDepartamentos !=null) 
					for(Departamento items:lstDepartamentos){ 
				%>
					<option value="<%=items.getId_depa()%>"><%=items.getNombre() %></option>
				<%		
					}
				
				%>
				
				</select><br>
				
				<input class= "btn btn-outline-primary" type="submit" name="accion" value="Agregar">
				<a  class= "btn btn-outline-danger" href="./provincias?accion=listar">Regresar</a> <br>		
			</form>
		</div>
		
	</div>
<%@ include file="../../template/inferior.jsp" %>