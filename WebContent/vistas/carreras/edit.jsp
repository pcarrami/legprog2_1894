<%@page import="com.cibertec.edu.matricula.entidades.Carrera"%>
<%@ include file="../../template/superior.jsp" %>
	<div class="container-fluid">
		<header>
			<label>CARRERAS</label>
		</header>
			<div class="col-lg-8">
				<h3>ACTUALIZAR CARRERA</h3>
				
				<%
					Carrera obj = (Carrera) request.getAttribute("obj");
				
				%>
				
				<form action="./carreras" method="post">
					ID: <br>
					<input class="form-control" type="text" readonly=true name="txt_id_carrera" value="<%=obj.getId_carrera()%>"> <br>
					NOMBRE: <br>
					<input class="form-control" type="text" name="txt_nombre" value="<%=obj.getNombre()%>"> <br>
					<input class= "btn btn-outline-primary" type="submit" name="accion" value="Actualizar">
					<a  class= "btn btn-outline-danger" href="./carreras?accion=listar">Regresar</a> <br>
				</form>
			</div>
			
	</div>
<%@ include file="../../template/inferior.jsp" %>