<%@page import="com.cibertec.edu.matricula.entidades.Departamento"%>
<%@ include file="../../template/superior.jsp" %>

	<div class="container-fluid">
		<header>
			<label>DEPARTAMENTOS</label>
		</header>
			<div class="col-lg-8">
				<h3>ACTUALIZAR DEPARTAMENTO</h3>
				
				<%
					Departamento obj = (Departamento) request.getAttribute("obj");
				
				%>
				
				<form action="./departamentos" method="post">
					ID: <br>
					<input class="form-control" type="text" readonly=true name="txt_id_depa" value="<%=obj.getId_depa()%>"> <br>
					NOMBRE: <br>
					<input class="form-control" type="text" name="txt_nombre" value="<%=obj.getNombre()%>"> <br>
					<input class= "btn btn-outline-primary" type="submit" name="accion" value="Actualizar">
					<a  class= "btn btn-outline-danger" href="./departamentos?accion=listar">Regresar</a> <br>
				</form>
			</div>
			
	</div>
<%@ include file="../../template/inferior.jsp" %>