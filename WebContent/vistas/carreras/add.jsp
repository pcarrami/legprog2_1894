<%@ include file="../../template/superior.jsp" %>

	<div class="container-fluid">
		<header>
		<label>CARRERAS</label>
		</header>
		<div class="col-lg-8">
			<h3>AGREGAR CARRERA</h3>
			
			<form action="./carreras" method="post">
				ID: <br>
				<input class="form-control" type="text" name="txt_id_carrera"> <br>
				NOMBRE: <br>
				<input class="form-control" type="text" name="txt_nombre"> <br>
				<input class= "btn btn-outline-primary" type="submit" name="accion" value="Agregar">
				<a  class= "btn btn-outline-danger" href="./carreras?accion=listar">Regresar</a> <br>		
			</form>
		</div>
		
	</div>
<%@ include file="../../template/inferior.jsp" %>