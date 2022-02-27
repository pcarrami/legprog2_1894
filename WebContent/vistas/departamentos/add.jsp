<%@ include file="../../template/superior.jsp" %>

	<div class="container-fluid">
		<header>
		<label>DEPARTAMENTOS</label>
		</header>
		<div class="col-lg-8">
			<h1>AGREGAR DEPARTAMENTO</h1>
			
			<form action="./departamentos" method="post">
				ID: <br>
				<input class="form-control" type="text" name="txt_id_depa"> <br>
				NOMBRE: <br>
				<input class="form-control" type="text" name="txt_nombre"> <br>
				<input class= "btn btn-outline-primary" type="submit" name="accion" value="Agregar">
				<a  class= "btn btn-outline-danger" href="./departamentos?accion=listar">Regresar</a> <br>		
			</form>
		</div>
		
	</div>
<%@ include file="../../template/inferior.jsp" %>